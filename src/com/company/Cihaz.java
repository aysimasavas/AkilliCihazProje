package com.company;

public class Cihaz {

    private float agirlik;
    private String model;
    private String renk;


    private Cihaz(CihazBuilder builder)
    {
        this.agirlik=builder.agirlik;
        this.model=builder.model;
        this.renk=builder.renk;
    }


    public float getAgirlik() {
        return agirlik;
    }

    public void setAgirlik(float agirlik) {
        this.agirlik = agirlik;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRenk() {
        return renk;
    }

    public void setRenk(String renk) {
        this.renk = renk;
    }


    public static class CihazBuilder{
        private float agirlik;
        private String model;
        private String renk;

        public CihazBuilder(float agirlik) {this.agirlik=agirlik;}
        public CihazBuilder model(String model)
        { this.model=model;return this;
        }
        public CihazBuilder renk (String renk)
        {
            this.renk=renk;
            return this;

        }
        public Cihaz build(){
            return new Cihaz(this);
        }
    }
}

