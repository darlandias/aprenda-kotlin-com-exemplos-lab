enum class Nivel {Basico, Intermediario, Avancado}

data class Usuario(val nome: String, val email: String, val usuario: String)

data class ConteudosEducacionais(val nome: String, val duracao: Int, val nivel: Nivel)

data class Formacao(val nome: String, val conteudos: List<ConteudosEducacionais>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
    
    fun imprimirListaInscritos(){
        for(user in inscritos){
            println(user.nome)
        }
    }
    
    fun imprimirGradeFormacao(){
        for(cont in conteudos){
            println("${cont.nome} - ${cont.duracao}")
        }
    }
}

fun main() {
    
    val moduloJava = ConteudosEducacionais("Curso de Java", 100, Nivel.Intermediario)
    val moduloKotlin = ConteudosEducacionais("Curso de Kotlin", 80, Nivel.Intermediario)
    val moduloDocker = ConteudosEducacionais("Curso de Docker", 50, Nivel.Avancado)
    
    val listConteudos = mutableListOf<ConteudosEducacionais>()
    listConteudos.add(moduloJava)
    listConteudos.add(moduloKotlin)
    listConteudos.add(moduloDocker)
    
    val formacaoAndroid = Formacao("Formação Backend Developer", listConteudos, Nivel.Avancado)
    
    val Mary = Usuario("Mary", "mary@mail.com", "pro")
    val Lass = Usuario("Lass", "lass@mail.com", "pro")
    val Ryan = Usuario("Ryan", "ryan@mail.com", "free")
    
    formacaoAndroid.matricular(Lass)
    formacaoAndroid.matricular(Ryan)
    
    print("Formação: ")
    println("${formacaoAndroid.nome} - ${formacaoAndroid.nivel}")
    println("Disciplinas propostas: ")
    println(formacaoAndroid.imprimirGradeFormacao())
    println()
    println("Lista de inscritos aceitos: ")
    println(formacaoAndroid.imprimirListaInscritos())
}