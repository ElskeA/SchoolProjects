package com.example.boompjes;

public class Knoop {
    public Object getUserObject() {
        return userObject;
    }

    //Inhoud van de knoop
    private Object userObject;
    private Knoop linkerKind, rechterKind;

    public Knoop(Object userObject)
    {
        this.userObject = userObject;
    }

    public Knoop(Object userObject, Knoop links, Knoop rechts)
    {
        this.userObject = userObject;
        this.linkerKind = links;
        this.rechterKind = rechts;
    }

    public void setUserObject(Object userObject) {
        this.userObject = userObject;
    }

    public Knoop getLinkerKind() {
        return linkerKind;
    }

    public void setLinkerKind(Knoop linkerKind) {
        this.linkerKind = linkerKind;
    }

    public Knoop getRechterKind() {
        return rechterKind;
    }

    public void setRechterKind(Knoop rechterKind) {
        this.rechterKind = rechterKind;
    }
}
