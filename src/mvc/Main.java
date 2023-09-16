package mvc;

import java.util.List;

import mvc.model.Aluno;
import mvc.model.dao.AlunoDAO;

public class Main {

	public static void main(String[] args) {
		AlunoDAO alunoDAO = new AlunoDAO();
		Aluno aluno = new Aluno();
        
		aluno.setCodigo(0);
		aluno.setNome("jogo");
		aluno.setNota_um(1);
		aluno.setNota_dois(2);
		aluno.setNota_tres(3);
		// fazer create
		alunoDAO.save(aluno);
		// fazer ready
	    List<Aluno> selecionarTodos = alunoDAO.getALL();
		// fazer update
	    alunoDAO.update(aluno);
		// fazer delete
        //alunoDAO.removeById(0);
	}
}
