package Model;

import javafx.beans.property.SimpleStringProperty;

public class Income {
    public SimpleStringProperty amounttable;
    public SimpleStringProperty typetable;
    public SimpleStringProperty informtable;

    public Income(String income, String type, String comment) {
        this.amounttable = new SimpleStringProperty(income);
        this.typetable = new SimpleStringProperty(type);
        this.informtable = new SimpleStringProperty(comment);
    }

    public Income() {
    }

    public String getIncome() {
        return amounttable.get();
    }

    public SimpleStringProperty incomeProperty() {
        return amounttable;
    }

    public void setIncome(String income) {
        this.amounttable.set(income);
    }

    public String getType() {
        return typetable.get();
    }

    public SimpleStringProperty typeProperty() {
        return typetable;
    }

    public void setType(String type) {
        this.typetable.set(type);
    }

    public String getComment() {
        return informtable.get();
    }

    public SimpleStringProperty commentProperty() {
        return informtable;
    }

    public void setComment(String comment) {
        this.informtable.set(comment);
    }
}
