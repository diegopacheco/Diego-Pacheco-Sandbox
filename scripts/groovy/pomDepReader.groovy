/**
 *  Script Groovy que le as dependencias de um pom atraves da api de xml e xmlns do Groovy.
 *  Esse script eh util para caso voce queira listar as dependencias de um pom. Quando vc estah conectado
 *  de forma remota no linux e nao queren abrir arquivo por arquivo no vim.
 *  
 *  @autor Diego Pacheco
 *  @since 05/05/2009
 *  @version 1.o
 *  
 */
 
def ns   = new groovy.xml.Namespace("http://maven.apache.org/POM/4.0.0", 'ns')
def root = new XmlParser().parseText(new File(args[0]).text)

def finder = { nodo ->
    def lista = new ArrayList()
    nodo.each{
      lista << (it.toString().substring(it.toString().indexOf("value=[") + 7,it.toString().length()).replace("]]",""))
    }
    return lista
}

def listG = finder(root[ns.dependencies][ns.dependency][ns.groupId])
def listA = finder(root[ns.dependencies][ns.dependency][ns.artifactId])
def listV = finder(root[ns.dependencies][ns.dependency][ns.version])

def count = 0
println "Dependencias desse pom:\n"
listG.each{    
    println "groupId: " + listG.get(count).padRight(50) + " artifactId: " + listA.get(count).padRight(50) + " version: " + listV.get(count)
    count++
}