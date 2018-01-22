package fachada;

import java.util.ArrayList;

import beans.Bebida;
import beans.Cozinheiro;
import beans.Funcionario;
import beans.Garcom;
import beans.Item;
import beans.Mesa;
import beans.Pedido;
import beans.Prato;
import gerenciamento.GerenciamentoFuncionarios;
import gerenciamento.GerenciamentoItens;
import gerenciamento.GerenciamentoMesas;
import gerenciamento.GerenciamentoPedidos;

public class Fachada {
	
	private static Fachada instance;

	private GerenciamentoFuncionarios funcionarios = new GerenciamentoFuncionarios();
	private GerenciamentoItens itens = new GerenciamentoItens();
	private GerenciamentoMesas mesas = new GerenciamentoMesas();
	private GerenciamentoPedidos pedidos = new GerenciamentoPedidos();
	
	private Fachada(){
		
	}
	
	
	
	public static Fachada getInstance() {
		if(instance == null){
			instance = new Fachada();
		}
		return instance;
	}



	public void cadastrarGarcom(Garcom a){
		funcionarios.cadastrarGarcom(a);
	}
	
	public void cadastrarCozinheiro(Cozinheiro a){
		funcionarios.cadastrarCozinheiro(a);
	}
	
	public boolean existe(Funcionario a){
		return funcionarios.existe(a);
	}
	
	public void removerFuncionario(Funcionario a){
		funcionarios.removerFuncionario(a);
	}
	
	public ArrayList<Funcionario> listarFuncionarios(){
		return funcionarios.listarFuncionarios();
	}
	
	public ArrayList<Garcom> listarGarcons(){
		return funcionarios.listarGarcons();
	}
	
	public ArrayList<Cozinheiro> listarCozinheiros(){
		return funcionarios.listarCozinheiros();
	}
	
	public Funcionario buscarFuncionario(String cpf){
		return funcionarios.buscarFuncionario(cpf);
	}
	
	public void cadastrarPrato(Prato a){
		itens.cadastrarPrato(a);
	}
	
	public void cadastrarBebida(Bebida a){
		itens.cadastrarBebida(a);
	}
	
	public void removerItem(Item a){
		itens.removerItem(a);
	}
	
	public ArrayList<Item> listarItens(){
		return itens.listarItens();
	}
	
	public ArrayList<Prato> listarPratos(){
		return itens.listarPratos();
	}
	
	public ArrayList<Bebida> listarBebidas(){
		return itens.listarBebidas();
	}
	
	public void cadastrarMesa(Mesa a){
		mesas.cadastrarMesa(a);
	}
	
	public void removerMesa(Mesa a){
		mesas.removerMesa(a);
	}
	
	public ArrayList<Mesa> listarMesas(){
		return mesas.listarMesas();
	}
	
	public Mesa buscarMesa(int id){
		return mesas.buscarMesa(id);
	}
	
	public boolean existe(int id){
		return mesas.existe(id);
	}
	
	public void cadastrarPedido(Pedido a){
		pedidos.cadastrarPedido(a);
	}
	
	public void removerPedido(Pedido a) {
		pedidos.removerPedido(a);
	}
	
	public ArrayList<Pedido> listarPedido(){
		return pedidos.listarPedido();
	}
}
