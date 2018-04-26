package com.example.luke.asynctaskdemo;


/**
 * Example :
 * {"id":"1","first_name":"Joshia","last_name":"Bruni","email":"jbruni0@free.fr","gender":"Male","ip_address":"129.135.147.239"},

 */
class Person {
    private String id;
    private String first_name;
    private String last_name;
    private String email;
    private String gender;
    private String ip_address;

   private Person(){}

    public static Builder builder(){
        return new Person.Builder();
    }

    public static class Builder {

        private Person instance = new Person();


        private Builder() {
        }
        public Builder id(String id){
            instance.id = id;
            return this;
        }
        public Builder first_name(String first_name){
            instance.first_name = first_name;
            return this;
        }
        public Builder last_name(String last_name){
            instance.last_name = last_name;
            return this;
        }
        public Builder email(String email){
            instance.email = email;
            return this;
        }
        public Builder gender(String gender){
            instance.gender= gender;
            return this;
        }
        public Builder ip_address(String ip_address){
            instance.ip_address= ip_address;
            return this;
        }

        public Person build(){
            assert instance.id != null : "id is null!!";
            return instance;
        }

    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", ip_address='" + ip_address + '\'' +
                '}';
    }

}
