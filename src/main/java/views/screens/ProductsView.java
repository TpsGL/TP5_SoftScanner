package views.screens;

import views.places.kernels.Place;

import javax.swing.*;


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

    }
}
