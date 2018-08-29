Nota: La principal diferencia entre Linux y Windows es el direccionamiento (Usado para acceder a los ficheros), de forma que:

#### En linux:
```
Path currentRelativePath = Paths.get("");
String s = currentRelativePath.toAbsolutePath().toString();
String direccionFichero = s + "/src/img/example.png"
```

#### En Windows:
```
Path currentRelativePath = Paths.get("");
String s = currentRelativePath.toAbsolutePath().toString();
String direccionFichero = s + "\\/src\\/img\\/example.png"
```

Además, el nombre del repositorio Maven es "TFG" mientras que el restante es el directorio Java normal de Eclipse.