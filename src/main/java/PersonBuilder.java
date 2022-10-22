public class PersonBuilder {
    private String name;
    private String surname;
    private int age;
    private String address;

    public PersonBuilder setName(String name) throws IllegalArgumentException {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Не указано имя");
        } else {
            this.name = name;
        }
        return this;
    }

    public PersonBuilder setSurname(String surname) throws IllegalArgumentException {
        if (surname == null || surname.isBlank()) {
            throw new IllegalArgumentException("Не указана фамилия");
        } else {
            this.surname = surname;
        }
        return this;
    }

    public PersonBuilder setAge(int age) throws IllegalArgumentException {
        if (age < 0) {
            throw new IllegalArgumentException("Не верно указан возраст");
        } else {
            this.age = age;
        }
        return this;
    }

    public PersonBuilder setAddress(String address) {
       this.address = address;
       return this;
    }

    public Person build() {
        Person person;
        if (name == null || name.isBlank() || surname == null || surname.isBlank()) {
            throw new IllegalStateException("Не все поля заполнены");
        }
        if (age < 0) {
            throw new IllegalStateException("Не верно указан возраст");
        }
        person = new Person(this.name, this.surname, this.age);
        person.setAddress(address);
        return person;
    }
}
