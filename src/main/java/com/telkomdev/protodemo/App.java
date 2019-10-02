package com.telkomdev.protodemo;

import com.google.protobuf.InvalidProtocolBufferException;

import java.util.ArrayList;
import java.util.List;

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

        Product p = new Product();
        p.setId("001");
        p.setName("Nokia 6");
        p.setQuantity(5);

        List<String> images = new ArrayList<String>();
        images.add("wuriyanto.com/img1");
        images.add("wuriyanto.com/img2");
        p.setImages(images);


        // serialize to protocol buffer
        byte[] protoByte = p.toProto().toByteArray();

        System.out.println(new String(protoByte));

        // deserialize from protocol buffer to java object
        try {
            Product product = Product.fromProto(protoByte);
            System.out.println(product.getId());
            System.out.println(product.getName());
            System.out.println(product.getQuantity());

            for(String image : product.getImages()) {
                System.out.println(image);
            }
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
    }
}
