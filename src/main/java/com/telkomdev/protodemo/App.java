package com.telkomdev.protodemo;

import com.google.protobuf.InvalidProtocolBufferException;

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
public class App {

    public static void main(String[] args) {

        ProductProtos.Product productOut = ProductProtos.Product.newBuilder()
                .setID("1")
                .setName("Nokia 6")
                .setQuantity(5)
                .addImages("nokia.com/img1")
                .addImages("nokia.com/img2")
                .build();

        // serialize product java to protobuf
        byte[] out = productOut.toByteArray();

        try {

            // deserialize protobuf to product java
            ProductProtos.Product productIn = ProductProtos.Product.parseFrom(out);

            System.out.println(productIn.getID());
            System.out.println(productIn.getName());
            System.out.println(productIn.getQuantity());

            System.out.println("Product images:");
            for (String image : productIn.getImagesList()) {
                System.out.println(image);
            }
        } catch (InvalidProtocolBufferException e) {
            System.out.print("error read proto message " + e.getMessage());
        }
    }
}
