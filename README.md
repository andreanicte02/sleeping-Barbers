# Manual Técnico:

Se manejaron 4 clases diferentes para resolver el problema:

| Clase                          | Descripción                                                  |
| ------------------------------ | ------------------------------------------------------------ |
| Gui                            | Clase utilizada para la interfaz del problema, su uso principal es visualizar el flujo del problema. |
| Measure Of Software Similarity | Clase que representa al barbero, hereda de la clase Thread.  |
| Client                         | Clase que representa al cliente, hereda de la clase Thread.  |
| BarberShop                     | Clase que representa la barbería, hereda de la clase Thread. |



## Barber class

##### Atributos:

```
    boolean isAsSleep = true; //se utiliza para saber el estado del Barbero
   
```



##### Metodos:

En este método solo ser verifica, si el barbero esta dormido, si no lo esta, se pone el hilo en espera, haciendo la llamada al método sleep.

```java
  @Override
    public void run() {
        while (true){
        	if(!isAsSleep){
            	sleep();
            }
        }
    }
```

Sleep es un método synchronized, el cual permite poner al hilo en espera, hasta que se haga un .notify, para reanudarlo.

```java

    public synchronized void sleep() throws InterruptedException {
    
        System.out.println("se durmio");
        isAsSleep =true;
        wait();
    }

```

Wakeup es un método synchronized, reanudar el hilo del barbero.

```java
 public synchronized void wakeup(){
        System.out.println("se desperto");
        notify();
  }
```

CutHair solamente duerme al hilo, mientras se simula que se esta cortando el cabello.

```java
    public void cutHair(JButton iconClient) throws InterruptedException {
        int n = (int) (Math.random() * (8000 - 5000)) + 5000;
        System.out.println("....cortando el pelo");
        Thread.sleep(n);
    }
```



## BarberShop Class

Es el hilo principal.

##### Atributos:

```java
    private Barber barber;
```

##### Metodos:

metodo-run, solo se usa, para mantener activo el hilo principal, activar el hilo del barbero.

```java
   public void run() {
        barber.start();
        while (true);
    }
```



## Client Class:

Hilo, donde se realiza el manejo de los estados del barbero.

##### Atributos:

```java
     BarberShop barberShop; 
    int id;
```

##### Metodos:

metodo-run, es el core, de este programa, siempre que se activa un cliente, se simula que esta entrando en la barbería, este verifica si el barbero, esta ocupado(o no esta durmiendo), para esperar, cuando el barbero se encuentra durmiendo, este lo despierta, realiza el corte de cabello y se vuelve a dormir.

Aquí es donde se hace uso de los métodos synchronized del barbero, ya que al despertarlo, se reanuda el el hilo, y luego de cortarse el cabello, el barbero se pone en espera.

```java
@Override
    public void run() {        
        while (true) {
       
       		if(!this.barber.isAsSleep){              
                System.out.println("ocupado");
                continue;
               
            }
            if(this.barber.isAsSleep){
                    
                this.barberShop.getBarber().wakeup();
                this.barberShop.getBarber().cutHair(icon);
                this.barberShop.getBarber().sleep();
                break;
            }
        }
    }

```



