class Calculator{

    int nOpDone;
    double lastRes;
    void build(){
        this.nOpDone = 0;
        this.lastRes = 0;
    }
    double add(double a, double b){
        this.nOpDone += 1;
        this.lastRes = a+b;
        return lastRes;
    }
    double sub(double a, double b){
        this.nOpDone += 1;
        this.lastRes = a-b;
        return lastRes;
    }
    double mul(double a, double b){
        this.nOpDone += 1;
        this.lastRes = a*b;
        return lastRes;
    }
    double div(double a, double b){
        this.nOpDone += 1;
        this.lastRes = a/b;
        return lastRes;
    }
}