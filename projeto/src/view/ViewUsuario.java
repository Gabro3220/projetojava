package view;

import java.time.LocalDate;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import banco.AgenteLocacaoBanco;
import banco.BalconistaBanco;
import banco.ClienteBanco;
import banco.UsuarioBanco;
import model.AgenteLocacao;
import model.Balconista;
import model.Cliente;

public class ViewUsuario {
    private Shell shell;
    private Text txtNomeCompleto, txtEmail, txtSenha, txtTelefone, txtEndereco;
    private Text txtCpf, txtCategoriaCnh, txtTurno, txtFilial, txtRegiaoAtuacao;
    private Table table;

    private ClienteBanco clienteBanco;
    private BalconistaBanco balconistaBanco;
    private AgenteLocacaoBanco agenteLocacaoBanco;
    private UsuarioBanco usuarioBanco;

    public ViewUsuario() {
        this.clienteBanco = new ClienteBanco();
        this.balconistaBanco = new BalconistaBanco();
        this.agenteLocacaoBanco = new AgenteLocacaoBanco();
        this.usuarioBanco = new UsuarioBanco();
    }
    public static void main(String[] args) {
        try {
            ViewUsuario window = new ViewUsuario();
            window.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void open() {
        Display display = Display.getDefault();
        createContents();
        shell.open();
        shell.layout();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }

    protected void createContents() {
        shell = new Shell();
        shell.setSize(900, 700);
        shell.setText("Cadastro de Usuário");

        // Campos comuns a todos os usuários
        Label lblNomeCompleto = new Label(shell, SWT.NONE);
        lblNomeCompleto.setBounds(20, 30, 120, 15);
        lblNomeCompleto.setText("Nome Completo:");

        txtNomeCompleto = new Text(shell, SWT.BORDER);
        txtNomeCompleto.setBounds(150, 30, 200, 21);

        Label lblEmail = new Label(shell, SWT.NONE);
        lblEmail.setBounds(20, 60, 100, 15);
        lblEmail.setText("Email:");

        txtEmail = new Text(shell, SWT.BORDER);
        txtEmail.setBounds(150, 60, 200, 21);

        Label lblSenha = new Label(shell, SWT.NONE);
        lblSenha.setBounds(20, 90, 100, 15);
        lblSenha.setText("Senha:");

        txtSenha = new Text(shell, SWT.BORDER | SWT.PASSWORD);
        txtSenha.setBounds(150, 90, 200, 21);

        Label lblTelefone = new Label(shell, SWT.NONE);
        lblTelefone.setBounds(20, 120, 100, 15);
        lblTelefone.setText("Telefone:");

        txtTelefone = new Text(shell, SWT.BORDER);
        txtTelefone.setBounds(150, 120, 200, 21);

        Label lblEndereco = new Label(shell, SWT.NONE);
        lblEndereco.setBounds(20, 150, 100, 15);
        lblEndereco.setText("Endereço:");

        txtEndereco = new Text(shell, SWT.BORDER);
        txtEndereco.setBounds(150, 150, 200, 21);

        // Radio Buttons para tipo de usuário
        Label lblTipoUsuario = new Label(shell, SWT.NONE);
        lblTipoUsuario.setBounds(20, 220, 120, 15);
        lblTipoUsuario.setText("Tipo de Usuário:");

        Button rbCliente = new Button(shell, SWT.RADIO);
        rbCliente.setBounds(150, 220, 100, 15);
        rbCliente.setText("Cliente");

        Button rbBalconista = new Button(shell, SWT.RADIO);
        rbBalconista.setBounds(260, 220, 100, 15);
        rbBalconista.setText("Balconista");

        Button rbAgenteLocacao = new Button(shell, SWT.RADIO);
        rbAgenteLocacao.setBounds(370, 220, 150, 15);
        rbAgenteLocacao.setText("Agente de Locação");

        // Campos específicos
        Label lblCpf = new Label(shell, SWT.NONE);
        lblCpf.setBounds(20, 260, 100, 15);
        lblCpf.setText("CPF:");
        lblCpf.setVisible(false);

        txtCpf = new Text(shell, SWT.BORDER);
        txtCpf.setBounds(150, 260, 200, 21);
        txtCpf.setVisible(false);

        Label lblCategoriaCnh = new Label(shell, SWT.NONE);
        lblCategoriaCnh.setBounds(20, 290, 120, 15);
        lblCategoriaCnh.setText("Categoria CNH:");
        lblCategoriaCnh.setVisible(false);

        txtCategoriaCnh = new Text(shell, SWT.BORDER);
        txtCategoriaCnh.setBounds(150, 290, 200, 21);
        txtCategoriaCnh.setVisible(false);

        Label lblTurno = new Label(shell, SWT.NONE);
        lblTurno.setBounds(20, 260, 100, 15);
        lblTurno.setText("Turno:");
        lblTurno.setVisible(false);

        txtTurno = new Text(shell, SWT.BORDER);
        txtTurno.setBounds(150, 260, 200, 21);
        txtTurno.setVisible(false);

        Label lblFilial = new Label(shell, SWT.NONE);
        lblFilial.setBounds(20, 290, 100, 15);
        lblFilial.setText("Filial:");
        lblFilial.setVisible(false);

        txtFilial = new Text(shell, SWT.BORDER);
        txtFilial.setBounds(150, 290, 200, 21);
        txtFilial.setVisible(false);

        Label lblRegiaoAtuacao = new Label(shell, SWT.NONE);
        lblRegiaoAtuacao.setBounds(20, 260, 150, 15);
        lblRegiaoAtuacao.setText("Região de Atuação:");
        lblRegiaoAtuacao.setVisible(false);

        txtRegiaoAtuacao = new Text(shell, SWT.BORDER);
        txtRegiaoAtuacao.setBounds(150, 260, 200, 21);
        txtRegiaoAtuacao.setVisible(false);

       
        Button btnCadastrar = new Button(shell, SWT.NONE);
        btnCadastrar.setBounds(20, 330, 150, 30);
        btnCadastrar.setText("Cadastrar Usuário");

        Button btnListar = new Button(shell, SWT.NONE);
        btnListar.setBounds(180, 330, 150, 30);
        btnListar.setText("Listar Usuários");

        table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
        table.setBounds(20, 380, 860, 250);
        table.setHeaderVisible(true);
        table.setLinesVisible(true);

        TableColumn colId = new TableColumn(table, SWT.NONE);
        colId.setWidth(50);
        colId.setText("ID");

        TableColumn colNome = new TableColumn(table, SWT.NONE);
        colNome.setWidth(150);
        colNome.setText("Nome");

        TableColumn colEmail = new TableColumn(table, SWT.NONE);
        colEmail.setWidth(150);
        colEmail.setText("Email");
        
        DateTime dateNasc = new DateTime(shell, SWT.BORDER);
        dateNasc.setBounds(160, 177, 80, 24);
        
        Label lblDataNascimento = new Label(shell, SWT.NONE);
        lblDataNascimento.setBounds(20, 186, 100, 15);
        lblDataNascimento.setText("Data Nascimento");

        rbCliente.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                lblCpf.setVisible(true);
                txtCpf.setVisible(true);
                lblCategoriaCnh.setVisible(true);
                txtCategoriaCnh.setVisible(true);
                lblDataNascimento.setVisible(true);
                dateNasc.setVisible(true);

                lblTurno.setVisible(false);
                txtTurno.setVisible(false);
                lblFilial.setVisible(false);
                txtFilial.setVisible(false);
                lblRegiaoAtuacao.setVisible(false);
                txtRegiaoAtuacao.setVisible(false);
            }
        });

        rbBalconista.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                lblTurno.setVisible(true);
                txtTurno.setVisible(true);
                lblFilial.setVisible(true);
                txtFilial.setVisible(true);

                lblCpf.setVisible(false);
                txtCpf.setVisible(false);
                lblCategoriaCnh.setVisible(false);
                txtCategoriaCnh.setVisible(false);
                lblRegiaoAtuacao.setVisible(false);
                txtRegiaoAtuacao.setVisible(false);
                lblDataNascimento.setVisible(false);
                dateNasc.setVisible(false);

            }
        });

        rbAgenteLocacao.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                lblRegiaoAtuacao.setVisible(true);
                txtRegiaoAtuacao.setVisible(true);

                lblCpf.setVisible(false);
                txtCpf.setVisible(false);
                lblCategoriaCnh.setVisible(false);
                txtCategoriaCnh.setVisible(false);
                lblTurno.setVisible(false);
                txtTurno.setVisible(false);
                lblFilial.setVisible(false);
                txtFilial.setVisible(false);
                lblDataNascimento.setVisible(false);
                dateNasc.setVisible(false);

            }
        });

        btnCadastrar.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                String nomeCompleto = txtNomeCompleto.getText();
                String email = txtEmail.getText();
                String senha = txtSenha.getText();
                String telefone = txtTelefone.getText();
                String endereco = txtEndereco.getText();
                LocalDate dataAtual = LocalDate.now();
                
                
                
               

                if (rbCliente.getSelection()) {
                	Integer idCliente = null;
                	String nivelAcesso = "1";
                    String cpf = txtCpf.getText();
                    String categoriaCNH = txtCategoriaCnh.getText();
                    LocalDate dataNascimento = LocalDate.of(dateNasc.getYear(), dateNasc.getMonth() + 1, dateNasc.getDay());
                    Cliente cliente = new Cliente(idCliente,nomeCompleto,email,senha,telefone,endereco,dataAtual,nivelAcesso,cpf,dataNascimento,categoriaCNH);
                    clienteBanco.incluir(cliente);
                    MessageBox box = new MessageBox(shell, SWT.OK);
                    box.setMessage("Cliente cadastrado com sucesso!");
                    box.open();
                } else if (rbBalconista.getSelection()) {
                	Integer idBalc = null;
                	String nivelAcesso = "2";
                    String turno = txtTurno.getText();
                    String filial = txtFilial.getText();
                    Balconista balconista = new Balconista();
                    balconistaBanco.incluir(balconista);
                    MessageBox box = new MessageBox(shell, SWT.OK);
                    box.setMessage("Balconista cadastrado com sucesso!");
                    box.open();
                } else if (rbAgenteLocacao.getSelection()) {
                	Integer idAgente = null;
                	String nivelAcesso = "3";
                    String regiaoAtuacao = txtRegiaoAtuacao.getText();
                    AgenteLocacao agente = new AgenteLocacao();
                    agenteLocacaoBanco.incluir(agente);
                    MessageBox box = new MessageBox(shell, SWT.OK);
                    box.setMessage("Agente de Locação cadastrado com sucesso!");
                    box.open();
                } else {
                    MessageBox box = new MessageBox(shell, SWT.ICON_WARNING);
                    box.setMessage("Selecione o tipo de usuário antes de cadastrar.");
                    box.open();
                }
            }
        });
        
        btnListar.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                table.removeAll(); 

                if (rbCliente.getSelection()) {
                    List<Cliente> clientes = clienteBanco.listarclientes();
                    for (Cliente cliente : clientes) {
                        TableItem item = new TableItem(table, SWT.NONE);
                        item.setText(new String[]{
                                String.valueOf(cliente.getIdUsuario()),
                                cliente.getNomeCompleto(),
                                cliente.getEmail(),
                                cliente.getCpf(),
                                cliente.getCategoriaCNH()
                        });
                    }
                } else if (rbBalconista.getSelection()) {
                    List<Balconista> balconistas = balconistaBanco.listar();
                    for (Balconista balconista : balconistas) {
                        TableItem item = new TableItem(table, SWT.NONE);
                        item.setText(new String[]{
                                String.valueOf(balconista.getIdUsuario()),
                                balconista.getNomeCompleto(),
                                balconista.getEmail(),
                                balconista.getTurno(),
                                balconista.getFilial()
                        });
                    }
                } else if (rbAgenteLocacao.getSelection()) {
                    List<AgenteLocacao> agentes = agenteLocacaoBanco.listar();
                    for (AgenteLocacao agente : agentes) {
                        TableItem item = new TableItem(table, SWT.NONE);
                        item.setText(new String[]{
                                String.valueOf(agente.getIdUsuario()),
                                agente.getNomeCompleto(),
                                agente.getEmail(),
                                agente.getRegiaoAtuacao()
                        });
                    }
                } else {
                    MessageBox box = new MessageBox(shell, SWT.ICON_WARNING);
                    box.setMessage("Selecione o tipo de usuário para listar.");
                    box.open();
                }
            }
        });
      
    }
}

