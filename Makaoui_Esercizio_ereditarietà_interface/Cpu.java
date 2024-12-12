package Makaoui_Esercizio_ereditarietà_interface;

public class Cpu {

    // Cpu general info
    private String cpuName;
    private int gen;
    private int cpuCore;
    private int cpuSpeed;

    // max Ram supported
    private int maxRam;

    // type of socket
    private int socketType;
    
    public Cpu(){
        cpuName = "Intel core I5";
        gen = 11;
        cpuCore = 6;
        cpuSpeed = 3600;
        maxRam = 64;
        socketType = 1200;
    }

    public Cpu(String cpuName, int gen, int cpuCore, int cpuSpeed, int maxRam, int socketType) {
        this.cpuName = cpuName;
        this.gen = gen;
        this.cpuCore = cpuCore;
        this.cpuSpeed = cpuSpeed;
        this.maxRam = maxRam;
        this.socketType = socketType;
    }

    // get
    public String getCpuName() {
        return cpuName;
    }
    public int getCpuCore() {
        return cpuCore;
    }
    public int getGen() {
        return gen;
    }
    public int getCpuSpeed() {
        return cpuSpeed;
    }
    public int getMaxRam() {
        return maxRam;
    }
    public int getSocketType() {
        return socketType;
    }

    // set
    public void setGen(int gen) {
        this.gen = gen;
    }
    public void setCpuName(String cpuName) {
        this.cpuName = cpuName;
    }
    public void setCpuCore(int cpuCore) {
        this.cpuCore = cpuCore;
    }
    public void setCpuSpeed(int cpuSpeed) {
        this.cpuSpeed = cpuSpeed;
    }
    public void setMaxRam(int maxRam) {
        this.maxRam = maxRam;
    }
    public void setSocketType(int socketType) {
        this.socketType = socketType;
    }

    @Override
    public String toString() {
        return "";
    }
}
