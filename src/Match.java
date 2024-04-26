public class Match {
    Fighter f1;
    Fighter f2;
    int minWeight;
    int maxWeight;

    Match(Fighter f1, Fighter f2, int minWeight, int maxWeight) {
        this.f1 = f1;
        this.f2 = f2;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
    }

    public void run() {
        if (isCheck()) {
            while (this.f1.health > 0 && this.f2.health > 0) {
                System.out.println("=== Yeni Round ===");
                if (isFirst()) {
                    this.f2.health = this.f1.hit(this.f2);
                    if (isWin()) {
                        break;
                    }
                    this.f1.health = this.f2.hit(this.f1);
                    if (isWin()) {
                        break;
                    }
                    printScore();
                } else {
                    this.f1.health = this.f2.hit(this.f1);
                    if (isWin()) {
                        break;
                    }
                    this.f2.health = this.f1.hit(this.f2);
                    if (isWin()) {
                        break;
                    }
                    printScore();
                }
            }
        } else {
            System.out.println("Sporcuların ağırlıkları uyuşmuyor.");
        }
    }

    public void printScore() {
        System.out.println("--------------------");
        System.out.println(this.f1.name + " health:" + " " + this.f1.health);
        System.out.println(this.f2.name + " health:" + " " + this.f2.health);
    }


    public boolean isWin() {
        if (this.f1.health == 0) {
            System.out.println("-------------");
            System.out.println(this.f2.name + " maçı kazanandı.");
            return true;
        }
        if (this.f2.health == 0) {
            System.out.println("-------------");
            System.out.println(this.f1.name + " maçı kazanandı.");
            return true;
        }
        return false;
    }

    public boolean isFirst() {
        double randomNumber = Math.random() * 100;
        return randomNumber <= 50;
    }

    public boolean isCheck() {
        return (this.f1.weight >= this.minWeight && this.f1.weight <= this.maxWeight) && (this.f2.weight >= this.minWeight && this.f2.weight <= this.maxWeight);
    }
}

