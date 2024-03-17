public class RadioSet {
    private int currentStation;
    private int currentVolume;
    private int stationLimit;

    public RadioSet() {
        this.stationLimit = 10;
    }

    public RadioSet(int stationLimit) {
        this.stationLimit = stationLimit;
    }

    public int getCurrentStation() {

        return currentStation;
    }

    public void getCurrentStation(int newCurrentStation) {
        if (newCurrentStation <= stationLimit - 1) {
            if (newCurrentStation >= 0) {
                this.currentStation = newCurrentStation;
            }
        }
    }

    public void next() {
        if (currentStation == stationLimit -1) {
            currentStation = 0;
        } else {
            currentStation++;
        }
    }

    public void prev() {
        if (currentStation == 0) {
            currentStation = stationLimit -1;
        } else {
            currentStation--;
        }
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void increaseVolume() {
        if (currentVolume < 100) {
            currentVolume++;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > 0) {
            currentVolume--;
        }
    }

}
