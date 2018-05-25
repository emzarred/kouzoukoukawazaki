package com.example.pc.footscore.Models.Head2Head;

import com.example.pc.footscore.Models.Fixture;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by pc on 09/05/2018.
 */

public class Heads {
    @SerializedName("fixture")
    @Expose
    private Fixture fixture;
    @SerializedName("head2head")
    @Expose
    private Head2head head2head;

    public Fixture getFixture() {
        return fixture;
    }

    public void setFixture(Fixture fixture) {
        this.fixture = fixture;
    }

    public Head2head getHead2head() {
        return head2head;
    }

    public void setHead2head(Head2head head2head) {
        this.head2head = head2head;
    }
}
