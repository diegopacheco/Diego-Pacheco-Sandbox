/**
 *  Script Groovy que deleta recursivamente todos os diretórios .svn de um working copy.
 *  Esse script eh util para caso voce queira limpar o seu working copy para criar um novo repositorio soh
 *  com o co nteudo do working copy ignorando o historico do svn.
 *  
 *  @autor Diego Pacheco
 *  @since 05/05/2009
 *  @version 1.o
 *  
 */

def dirDigger
dirDigger = { path -> 
      new File(path.toString()).eachDir{ f ->
          dirDigger f.toString()
      }             
      if (path.toString().contains(".svn")) {
          println "deletando: $path"
          deleteDir(new File(path.toString()))
      }      
}

boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i=0; i<children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        return dir.delete();
}

dirDigger args[0]