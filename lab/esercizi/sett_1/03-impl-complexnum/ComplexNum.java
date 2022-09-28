class ComplexNum {
    
    double re;
    double im;

    void build(double re, double im) {
        this.re = re;
        this.im = im;
    }

    boolean equal(ComplexNum num) {
        if(this.re == num.re && this.im == num.im)
            return true;
        return false;
    }

    void add(ComplexNum num) {
        this.re += num.re;
        this.im += num.im;
    }

    String toStringRep() {
        String finalString = (this.re != 0 ? String.format("%.2f",this.re) : "") + (this.im > 0 ? "+" : "") + (this.im != 0 && this.im != 1 && this.im != -1 ? String.format("%.2f", this.im) : "") + "i";
        return finalString;
    }
}