package com.ucelebi.springbootrabbitmq.model;

import java.io.Serializable;

/**
 * @author UMITCELEBI
 */
public class SimpleMessage implements Serializable {
    private String name;
    private String description;

    public SimpleMessage(Builder builder) {
        this.name=builder.name;
        this.description=builder.description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static class Builder{
        private String name;
        private String description;

        public Builder() {
        }

        public Builder name(String name) {
            this.name=name;
            return this;
        }

        public Builder description(String description) {
            this.description=description;
            return this;
        }

        public SimpleMessage build(){
            return new SimpleMessage(this);
        }

    }
}
