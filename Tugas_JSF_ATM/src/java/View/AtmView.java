/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.AtmModel;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.bean.ManagedBean;

@ManagedBean(name = "UserBank") 
@RequestScoped 

public class AtmView {
    private AtmModel model;
    private String responSetorTunani;
    private String responTarikTunani;
    private int jumlah;
    
    public AtmView() {
        model = new AtmModel();
    }

    public String getResponSetorTunani() {
        if(model.cekTransaksi(jumlah)==1){
            model.tambahSaldo(jumlah);
            return "Setor Tunai berhasil";
        } else{
            return ("Setor Tunai harus kelipatan 50000");
        }
    } 

    public String getResponTarikTunani() {
                
        if(model.cekBatasSaldo()){
            return "Saldo Anda Mencapai Limit";
        } else if((model.getSaldo()- jumlah)< model.limitSaldo()){
            return "Jumlah Penarikan melebihi limit penarikan";
        } else if((model.getSaldo()> jumlah) && (model.cekTransaksi(jumlah) == 1)){
            model.tarikSaldo(jumlah);
            return "Tarik Tunai Berhasil";
        } else{
            return  "Penarikan harus kelipatan 50000";
        }    
    
    }  
    
    public int cekSaldo(){
        return model.getSaldo();
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
   
}     