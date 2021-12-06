package productApp.views.screens;

import productApp.views.places.kernels.Place;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class ProductsView extends JFrame {

    private JButton addProductButton;
    private JPanel rootPanel;
    private JTextField productNameFieldText;
    private JTextField priceTextField;
    private JTextField ExperDateTextField;
    private JComboBox productIdComboBox;
    private JButton searchButton;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JTable productReviewTable;
    private JScrollPane scrollePane;



    public ProductsView() {

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Price");
        model.addColumn("Date Expiration");

        productReviewTable.setModel(model);

        productReviewTable.setRowSelectionAllowed(true);

        setContentPane(rootPanel);
    }


    public JButton getAddProductButton() {
        return addProductButton;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    public JComboBox getProductIdComboBox() {
        return productIdComboBox;
    }

    public JScrollPane getScrollePane() {
        return scrollePane;
    }

    public JTable getProductReviewTable() {
        return productReviewTable;
    }

    public JTextField getExperDateTextField() {
        return ExperDateTextField;
    }

    public JTextField getPriceTextField() {
        return priceTextField;
    }

    public JTextField getProductNameFieldText() {
        return productNameFieldText;
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    Presenter presenter;

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public interface Presenter{
        public void goTo(Place place);
        public void addBtnEvent();
        public void searchBtnEvent();
        public void updateBtnEvent();
        public void deleteBtnEvent();

    }
}
