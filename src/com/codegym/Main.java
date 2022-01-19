package com.codegym;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ProductManagement productManagement = new ProductManagement();
        Product product1 = new Product(1, "abc", 250);
        Product product2 = new Product(2, "sdf", 250);
        Product product3 = new Product(3, "deg", 250);
        productManagement.addNewProduct(0, product1);
        productManagement.addNewProduct(1, product2);
        productManagement.addNewProduct(2, product3);
        int choice = -1;
        do {
            menu();
            System.out.println("Mời bạn nhập lựa chọn");
            choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("---Hiển thị toàn bộ sản phẩm---");
                    productManagement.showAllProducts();

                    break;
                }
                case 2: {
                    System.out.println("---Thêm Product---");
                    System.out.println("Nhập vị trí muốn thêm");
                    int index = scanner.nextInt();
                    if (index < 0 || index > productManagement.size()) {
                        System.out.println("Vị trí không hợp lệ");
                    } else {
                        Product newProduct = getProduct();
                        productManagement.addNewProduct(index, newProduct);
                    }
                    break;
                }
                case 3: {
                    System.out.println("---Cập nhật thông tin sản phẩm---");
                    System.out.println("Nhập vị trí muốn cập nhật");
                    int index = scanner.nextInt();
                    if (index < 0 || index > productManagement.size()) {
                        System.out.println("Vị trí không hợp lệ");
                    } else {
                        Product product = getProduct();
                        productManagement.UpdateProducts(index, product);
                    }
                    break;
                }
                case 4: {
                    System.out.println(" ---Xóa sản phẩm---");
                    System.out.println("Nhập vị trí muốn xóa");
                    int index = scanner.nextInt();
                    if (index < 0 || index >= productManagement.size()) {
                        System.out.println("Vị trí không hợp lệ");
                    } else {
                        productManagement.removeProduct(index);
                    }
                    break;
                }
                case 5: {
                    System.out.println("--- Tìm kiếm sản phẩm theo tên");
                    scanner.nextLine();
                    System.out.println("Nhập tên SP muốn tìm");
                    String name = scanner.nextLine();
                    int index = productManagement.searchProduct(name);
                    if (index == -1){
                        System.out.println("Không có SP");
                    }
                    else {
                        System.out.println("Thông tin SP là: " + productManagement.getProduct(index));
                    }

                    break;
                }
                case 6: {
                    System.out.println("---Sắp xếp SP theo tên từ A");
                    productManagement.sortList(new ProductNameComparator());
                    break;
                }
                case 7: {
                    System.out.println("---Sắp xếp SP theo tên từ Z");
                    productManagement.sortList(new ProductNameComparator().reversed());
                    break;
                }
                default: {
                    System.out.println(" nhập từ 1 -> 7");
                    break;
                }
            }

        } while (choice != 0);

    }

    public static Product getProduct() {
        System.out.println("Nhập thông tin product");
        System.out.println("Nhập id");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập tên");
        String name = scanner.nextLine();
        System.out.println("Nhập giá");
        double price = scanner.nextDouble();
        Product newProduct = new Product(id, name, price);
        return newProduct;
    }

    private static void menu() {
        System.out.println("---Menu qunar lý sản phẩm---");
        System.out.println("1. Hiển thị toàn bộ sản phẩm");
        System.out.println("2. Thêm sản phẩm");
        System.out.println("3. Cập nhật thông tin sản phẩm");
        System.out.println("4. Xóa sản phẩm");
        System.out.println("5. Tìm kiếm sản phẩm theo tên");
        System.out.println("6. Sắp xếp sản phẩm theo giá tăng dần");
        System.out.println("0. Thoát chương trình");
    }
}
