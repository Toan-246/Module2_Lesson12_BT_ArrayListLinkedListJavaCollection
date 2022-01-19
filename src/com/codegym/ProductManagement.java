package com.codegym;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductManagement {
    private List<Product> productLists = new ArrayList<>();

    public ProductManagement() {
    }

    public int size() {
        return productLists.size();
    }

    public void showAllProducts() {
        if (size() == 0) {
            System.out.println("không sản phẩm nào");
        } else {
            for (int i = 0; i < productLists.size(); i++) {
                System.out.println(productLists.get(i));
            }
        }

    }

    public void addNewProduct(int index, Product newProduct) {
        productLists.add(index, newProduct);
    }

    public void UpdateProducts(int index, Product product) {
        productLists.set(index, product);
    }

    public void removeProduct(int index) {
        productLists.remove(index);
    }

    //    public int searchProduct(String name) {
//        int index = -1;
//        for (int i = 0; i < size(); i++) {
//            if (productLists.get(i).getName().equalsIgnoreCase(name)) {
//                index = i;
//                break;
//            }
//
//        }
//        return index;
//    }
    public int searchProduct(String name) {
        int index = -1;
        for (int i = 0; i < size(); i++) {
            if (productLists.get(i).getName().equalsIgnoreCase(name)) {
                index = i;
                break;
            }

        }
        return index;
    }

    public Product getProduct(int index) {
        return productLists.get(index);
    }


    public void sortList(Comparator<Product> comparator){
        Collections.sort(productLists, comparator);
    }
}
