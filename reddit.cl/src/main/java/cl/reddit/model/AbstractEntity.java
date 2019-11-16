package cl.reddit.model;

import java.io.Serializable;

public abstract class AbstractEntity implements Serializable {
    public abstract Serializable getId();
}
