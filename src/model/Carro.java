/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Familia
 */
public class Carro implements Comparable<Carro>{
    
    private String marca;
    private String modelo;
    private String color;
    private String placa;
    private double precio;

    public Carro() {
    }

    public Carro(String marca, String modelo, String color, String placa, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.placa = placa;
        this.precio = precio;
    }

    /**
     * Get the value of precio
     *
     * @return the value of precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Set the value of precio
     *
     * @param precio new value of precio
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }


    /**
     * Get the value of placa
     *
     * @return the value of placa
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * Set the value of placa
     *
     * @param placa new value of placa
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }


    /**
     * Get the value of color
     *
     * @return the value of color
     */
    public String getColor() {
        return color;
    }

    /**
     * Set the value of color
     *
     * @param color new value of color
     */
    public void setColor(String color) {
        this.color = color;
    }


    /**
     * Get the value of modelo
     *
     * @return the value of modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Set the value of modelo
     *
     * @param modelo new value of modelo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }


    /**
     * Get the value of marca
     *
     * @return the value of marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Set the value of marca
     *
     * @param marca new value of marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public int compareTo(Carro otroCarro) {
        return this.placa.compareTo(otroCarro.placa);
    }

    @Override
    public String toString() {
        return marca + " " + modelo + " " + placa + "\n";
    }
}
