package Visual.Characters;

public class Lokasyon {
    private int koordinatX;
    private int koordinatY;

    public int getKoordinatX() {
        return koordinatX;
    }

    public int getKoordinatY() {
        return koordinatY;
    }

    public void setKoordinatX(int koordinatX) {
        this.koordinatX = koordinatX;
    }

    public void setKoordinatY(int koordinatY) {
        this.koordinatY = koordinatY;
    }

    public Lokasyon (int koordinatX, int koordinatY) {
        this.koordinatX = koordinatX;
        this.koordinatY = koordinatY;
    }
}