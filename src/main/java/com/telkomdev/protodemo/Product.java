package com.telkomdev.protodemo;

/*
 * Copyright 2019 wuriyanto.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.google.protobuf.InvalidProtocolBufferException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Product {

    private String id;
    private String name;
    private Integer quantity;
    private List<String> images;

    public Product() {

    }

    public Product(String id, String name, Integer quantity, List<String> images) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.images = images;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", images=" + images +
                '}';
    }

    public ProductProtos.Product toProto() {
        ProductProtos.Product productOut = ProductProtos.Product.newBuilder()
                .setID(this.id)
                .setName(this.name)
                .setQuantity(this.quantity)
                .addAllImages(this.images)
                .build();
        return productOut;
    }

    public static Product fromProto(byte[] in) throws InvalidProtocolBufferException {
        ProductProtos.Product productIn = ProductProtos.Product.parseFrom(in);
        Product product = new Product();
        product.setId(productIn.getID());
        product.setName(productIn.getName());
        product.setQuantity((int) productIn.getQuantity());
        List<String> images = new ArrayList<>();
        for (String image : productIn.getImagesList()) {
            images.add(image);
        }

        product.setImages(images);
        return product;
    }

    public static Product fromProto(InputStream in) throws IOException {
        ProductProtos.Product productIn = ProductProtos.Product.parseFrom(in);
        Product product = new Product();
        product.setId(productIn.getID());
        product.setName(productIn.getName());
        product.setQuantity((int) productIn.getQuantity());
        List<String> images = new ArrayList<>();
        for (String image : productIn.getImagesList()) {
            images.add(image);
        }

        product.setImages(images);
        return product;
    }
}
