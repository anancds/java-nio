package com.cds.learn.mapdb;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class CollectionTest {


    public static void main(String[] args) {
        Random random = new Random();
        List<Entity> list = new ArrayList<>();
        for (int i = 0; i < 20; i++ ) {

            Entity entity = new Entity();
            entity.setId(i);
            entity.setNorm(0.22f);
            list.add(entity);
        }
        Entity e1 = new Entity();
        e1.setId(55);
        e1.setNorm(0.55f);
        list.add(e1);
        Entity e2 = new Entity();
        e1.setId(56);
        e1.setNorm(0.55f);
        list.add(e1);
        for (int i = 0; i < 20; i ++) {
            System.out.println(list.get(i));
        }

        System.out.println("----------------------");

        long t1 = System.currentTimeMillis();
        Collections.sort(list, new Comparator<Entity>() {
            @Override
            public int compare(Entity o1, Entity o2) {
                if (o1.getNorm() >= o2.getNorm()) {
                    return -1;
                }else if (o1.getNorm() == o2.getNorm()){
                    return 0;
                } else {
                    return 1;
                }
            }
        });

        System.out.println(System.currentTimeMillis() - t1);
        for (int i = 0; i < 20; i ++) {
            System.out.println(list.get(i));
        }

    }

    private static class Entity {
        int id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public float getNorm() {
            return norm;
        }

        public void setNorm(float norm) {
            this.norm = norm;
        }

        float norm;

        @Override
        public String toString() {
            return "Entity{" +
                    "id=" + id +
                    ", norm=" + norm +
                    '}';
        }
    }
}
