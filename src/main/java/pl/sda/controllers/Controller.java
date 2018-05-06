package pl.sda.controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import pl.sda.model.Item;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    @FXML
    private ListView<Item> itemList;

    @FXML
    private Button addOrderButton;

    @FXML
    private ListView<Item> yourItemList;


    public  void initialize(){
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("JPA");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();



        itemList.getItems().addAll(showItemList(entityManager));
        itemList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        addOrderButton.setOnAction(event -> addItemsToOrder());


        entityManager.getTransaction().commit();


        entityManager.close();
        emf.close();


    }

    private void addItemsToOrder() {
        ObservableList<Item> items;
        items = itemList.getSelectionModel().getSelectedItems();

        List<Item> itemList = new ArrayList<>();
        itemList.addAll(items);
        yourItemList.getItems().addAll(itemList);

    }

    private  List<Item> showItemList(EntityManager entityManager) {
        List<Item> itemList = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            Item item = entityManager.find(Item.class, i);
            itemList.add(item);
        }
        return itemList;

    }


}
