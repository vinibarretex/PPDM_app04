package com.example.app_04_listacompras

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //criação das variaveis com os objetos visuais
        val listViewProduto = findViewById<ListView>(R.id.listViewProduto)
        val btnInserir = findViewById<Button>(R.id.btnInserir)
        val txtProduto = findViewById<TextView>(R.id.txtProduto)

        //criando o adaptador
        val produtosAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)

        //definição do adaptador para lista
        listViewProduto.adapter = produtosAdapter

        btnInserir.setOnClickListener {
            val produto = txtProduto.text.toString()
            if(txtProduto.text.isNotEmpty()){
                produtosAdapter.add(produto)
            } else {
                txtProduto.error = "Digite o nome de um produto"
            }
            txtProduto.text = "" //limpa o campo de texto
        }

        listViewProduto.setOnItemClickListener { adapterView: AdapterView<*>, //clique no item
            view, position: Int, id: Long ->
            val item = produtosAdapter.getItem(position)
            produtosAdapter.remove(item)
        }
    }
}