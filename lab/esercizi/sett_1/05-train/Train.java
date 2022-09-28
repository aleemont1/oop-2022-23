class Train {
    int nTotSeats;
    int nFirstClassSeats;
    int nSecondClassSeats;
    int nFirstClassReservedSeats;
    int nSecondClassReservedSeats;

    void build(int nFirstClassSeats, int nSecondClassSeats){
        this.nFirstClassReservedSeats = 0;
        this.nSecondClassReservedSeats = 0;
        this.nFirstClassSeats = nFirstClassSeats;
        this.nSecondClassSeats = nSecondClassSeats;
        this.nTotSeats = nFirstClassSeats + nSecondClassSeats;
    }

    void reserveFirstClassSeats(int n){
        if(this.nFirstClassReservedSeats + n <= nFirstClassSeats)
            this.nFirstClassReservedSeats += n;
    }

    void reserveSecondClassSeats(int n){
        if(this.nSecondClassReservedSeats + n <= nSecondClassSeats)
            this.nSecondClassReservedSeats += n;
    }

    double getTotOccupancyRatio(){
        int totOccup = this.nFirstClassReservedSeats + this.nSecondClassReservedSeats;
        return ((double)totOccup/(double)this.nTotSeats)*100;
    }
    double getFirstClassOccupancyRatio(){
        return ((double)this.nFirstClassReservedSeats/(double)nFirstClassSeats)*100;
    }
    double getSecondClassOccupancyRatio(){
        return ((double)this.nSecondClassReservedSeats/(double)nSecondClassSeats)*100;
    }
    void deleteAllReservations(){
        this.nFirstClassReservedSeats = 0;
        this.nSecondClassReservedSeats = 0;
    }
}
