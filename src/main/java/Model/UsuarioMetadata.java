package Model;



public class UsuarioMetadata {

	private long IdUsuarioMetadata;
	
	private long IdUsuario;
	
	private String valor;
	
	private String Tipo;

	public long getIdUsuarioMetadata() {
		return IdUsuarioMetadata;
	}

	public void setIdUsuarioMetadata(long idUsuarioMetadata) {
		IdUsuarioMetadata = idUsuarioMetadata;
	}

	public long getIdUsuario() {
		return IdUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		IdUsuario = idUsuario;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	
	
}
