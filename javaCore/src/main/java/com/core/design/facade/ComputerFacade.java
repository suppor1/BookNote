package com.core.design.facade;

/**
 * Created by jiangkai
 * Date 2018/9/20
 */
public class ComputerFacade {
    private Memory memory;
    private Disk disk;
    private Cpu cpu;

    public ComputerFacade() {
        this.memory = new Memory();
        this.disk = new Disk();
        this.cpu = new Cpu();
    }

    public void start(){
        memory.start();
        disk.start();
        cpu.start();
        System.out.println("computer start.......");
    }

    public void shutdown(){
        memory.shutdown();
        disk.shutdown();
        cpu.shutdown();
        System.out.println("computer shutdown.......");
    }
}
