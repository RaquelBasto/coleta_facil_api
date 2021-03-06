package br.com.coletafacil.ColetaFacil.model;

import br.com.coletafacil.ColetaFacil.repository.ColetorRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Optional;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Coletor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idColetor;

    private String cpf;

    private String nome;

    private Integer pontos;

    private String veiculo;

    private String endereco;

    private String cep;

    private String contato;

    public Optional<Coletor> atualizar(Long id, ColetorRepository coletorRepository){

        Optional<Coletor> coletorEntity = coletorRepository.findById(id);

        coletorEntity.get().setIdColetor(this.idColetor);
        coletorEntity.get().setCep(this.cep);
        coletorEntity.get().setContato(this.contato);
        coletorEntity.get().setCpf(this.cpf);
        coletorEntity.get().setNome(this.nome);
        coletorEntity.get().setPontos(this.pontos);
        coletorEntity.get().setVeiculo(this.veiculo);
        coletorEntity.get().setEndereco(this.endereco);

        coletorRepository.save(coletorEntity.get());

        return coletorEntity;
    }
}
