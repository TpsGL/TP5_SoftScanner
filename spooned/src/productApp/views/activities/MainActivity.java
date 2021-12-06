package productApp.views.activities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import productApp.entities.Product;
import productApp.entities.User;
import productApp.repository.ProductRepository;
import productApp.strategy.InMemoryStrategy;
import productApp.views.activities.kernels.Activity;
import productApp.views.factory.ClientFactory;
import productApp.views.places.MainPlace;
import productApp.views.places.kernels.Place;
import productApp.views.screens.ProductsView;
import productApp.views.validator.IValidator;
import productApp.views.validator.ValidatorImpl;
import javax.swing.*;
public class MainActivity implements Activity , ProductsView.Presenter {
    ClientFactory factory;

    String name;

    ProductsView productsView;

    IValidator iValidator = new ValidatorImpl();

    ProductRepository productRepository = ProductRepository.getInstance();

    String productName;

    String productDateExpiration;

    float productPrice;

    Product product;

    User user;

    public MainActivity(MainPlace mainPlace, ClientFactory clientFactory, User user) {
        this.user = user;
        this.factory = clientFactory;
        productRepository.init(new InMemoryStrategy<Product>());
        this.name = mainPlace.getPlaceName();
        start();
    }

    @Override
    public void start() {
        productsView = factory.getMainView();
        productsView.setTitle("Crud Product");
        productsView.setVisible(true);
        productsView.setBounds(590, 120, 800, 600);
        productsView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        productsView.setResizable(true);
        productsView.setPresenter(this);
        bindEvents();
    }

    private void bindEvents() {
        addBtnEvent();
        searchBtnEvent();
        updateBtnEvent();
        deleteBtnEvent();
    }

    @Override
    public void goTo(Place place) {
    }

    @Override
    public void addBtnEvent() {
        productsView.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // check and init Items
                checkYourItem();
                Product product = new Product();
                product.setName(productName);
                product.setExpirationDate(productDateExpiration);
                product.setPrice(productPrice);
                product = productRepository.add(product);
                // reset fields !!
                reset();
                // Show date in Table
                addProductToTable(product);
                // add Id to Combo Box
                productsView.getProductIdComboBox().addItem(product.getId());
                // Operation operation = new Operation(user,product, CRUD.CREATE);
                // LoggingHelper.getInstance().log(operation);
                Operation operation = new Operation(user,product, CRUD.CREATE);
                LoggingHelper.getInstance().log(operation);
            }
        });
    }

    private void addProductToTable(Product product) {
        DefaultTableModel model = ((DefaultTableModel) (productsView.getProductReviewTable().getModel()));
        Vector vector = new Vector();
        vector.add(product.getId());
        vector.add(product.getName());
        vector.add(product.getPrice());
        vector.add(product.getExpirationDate());
        model.addRow(vector);
    }

    @Override
    public void searchBtnEvent() {
        productsView.getSearchButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String item = productsView.getProductIdComboBox().getSelectedItem().toString();
                product = productRepository.get(item);
                // show product !!
                showProduct(product);
                // Operation operation = new Operation(user, product, CRUD.SEARCH);
                // LoggingHelper.getInstance().log(operation);
                Operation operation = new Operation(user,product, CRUD.SEARCH);
                LoggingHelper.getInstance().log(operation);
            }
        });
    }

    private void showProduct(Product product) {
        productsView.getPriceTextField().setText("" + product.getPrice());
        productsView.getExperDateTextField().setText(product.getExpirationDate());
        productsView.getProductNameFieldText().setText(product.getName());
    }

    @Override
    public void updateBtnEvent() {
        productsView.getUpdateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                product.setName(productName);
                product.setPrice(productPrice);
                product.setExpirationDate(productDateExpiration);
                Product product1 = productRepository.update(product);
                int row = getRowTable(product1.getId());
                updateRowTable(row, product1);
                reset();
                // Operation operation = new Operation(user, product, CRUD.UPDATE);
                // LoggingHelper.getInstance().log(operation);
                Operation operation = new Operation(user,product, CRUD.UPDATE);
                LoggingHelper.getInstance().log(operation);
            }
        });
    }

    private void updateRowTable(int row, Product product) {
        productsView.getProductReviewTable().getModel().setValueAt(product.getName(), row, 1);
        productsView.getProductReviewTable().getModel().setValueAt(product.getPrice(), row, 2);
        productsView.getProductReviewTable().getModel().setValueAt(product.getExpirationDate(), row, 3);
    }

    private int getRowTable(String productId) {
        JTable jTable = productsView.getProductReviewTable();
        for (int i = 0; i < jTable.getRowCount(); i++) {
            // For each row
            if (jTable.getModel().getValueAt(i, 0).equals(productId)) {
                // Search the model
                return i;// Print if found string

            }
        }// For loop outer

        return 0;
    }

    @Override
    public void deleteBtnEvent() {
        productsView.getDeleteButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = product.getId();
                int row = getRowTable(id);
                productRepository.remove(id);
                DefaultTableModel model = ((DefaultTableModel) (productsView.getProductReviewTable().getModel()));
                model.removeRow(row);
                reset();
                // Operation operation = new Operation(user, product, CRUD.DELETE);
                // LoggingHelper.getInstance().log(operation);
                Operation operation = new Operation(user,product, CRUD.DELETE);
                LoggingHelper.getInstance().log(operation);
            }
        });
    }

    /**
     *
     */
    private void checkYourItem() {
        productName = productsView.getProductNameFieldText().getText();
        iValidator.isValidStr(productName, "[A-Za-z0-9_]+");
        productDateExpiration = productsView.getExperDateTextField().getText();
        iValidator.isValidateDate(productDateExpiration);
        String str = productsView.getPriceTextField().getText();
        productPrice = iValidator.isFloat(str, 1000.0F);
    }

    /**
     *
     */
    public void reset() {
        productsView.getProductNameFieldText().setText("");
        productsView.getExperDateTextField().setText("");
        productsView.getPriceTextField().setText("");
    }
}