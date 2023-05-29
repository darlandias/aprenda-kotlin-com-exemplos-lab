enum class Nivel {Nivel1, Nivel2, Nivel3}

data class Aluno(val nome: String, val email: String, val aluno: String)

data class Conteudo(val nome: String, val duracao: Int, val nivel: Nivel)

data class Formacao(val nome: String, val conteudos: List<Conteudo>, val nivel: Nivel) {

    val inscritos = mutableListOf<Aluno>()
    
    fun matricular(aluno: Aluno) {
        inscritos.add(aluno)
    }
    
    fun imprimirAlunosInscritos(){
        for(user in inscritos){
            println(user.nome)
        }
    }
    
    fun imprimirConteudoCurricular(){
        for(cont in conteudos){
            println("${cont.nome} - ${cont.duracao}")
        }
    }
}

fun main() {
    
    val moduloJava = Conteudo("Curso de Java", 100, Nivel.Nivel1)
    val moduloKotlin = Conteudo("Curso de Kotlin", 80, Nivel.Nivel3)
    val moduloDocker = Conteudo("Curso de Docker", 50, Nivel.Nivel2)
    
    val listConteudos = mutableListOf<Conteudo>()
    listConteudos.add(moduloJava)
    listConteudos.add(moduloKotlin)
    listConteudos.add(moduloDocker)
    
    val formacao1 = Formacao("Formação Backend Developer", listConteudos, Nivel.Nivel3)
    
    val Mary = Aluno("Mary", "mary@mail.com", "pro")
    val Lass = Aluno("Lass", "lass@mail.com", "pro")
    val Ryan = Aluno("Ryan", "ryan@mail.com", "free")
    
    formacao1.matricular(Lass)
    formacao1.matricular(Ryan)
    
    print("Formação: ")
    println("${formacao1.nome} - ${formacao1.nivel}")
    println("Disciplinas propostas: ")
    println(formacao1.imprimirConteudoCurricular())
    println()
    println("Lista de inscritos aceitos: ")
    println(formacao1.imprimirAlunosInscritos())
}