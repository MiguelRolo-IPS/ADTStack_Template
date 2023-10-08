package pt.pa.adts;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.Objects;

/**
 * Isto é uma Classe "StackArrayList" herdada da interface "Stack".
 *
 * @param <T> tipo de armazenamento genérico
 *
 * @version %I% %G%
 * @author Miguel Rôlo
 */
public class StackArrayList<T> implements Stack<T> {

    /**
     * Declaração de uma variável estática do tipo inteiro, define a capacidade máxima da Stack.
     */
    private static final int DEFAULT_CAPACITY = 40;

    /**
     * Array do tipo genérico, que armazena todos os elementos da Stack.
     */
    private T[] elements;
    /**
     * Variável do tipo inteiro que representa o tamanho da nossa Stack.
     */
    private int size;

    /**
     * Criação do array Stack, inicia vazio porém com capacidade 40;
     */
    @SuppressWarnings("unchecked")
    public StackArrayList() {
        this.elements = (T[])new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    /**
     * Adiciona elementos à Stack.
     * @param element             Tipo de armazenamento genérico
     * @throws FullStackException Devolve uma string quando a Stack estiver cheia.
     */
    @Override
    public void push(T element) throws FullStackException {
        if(this.size >= this.elements.length) {
            elements = Arrays.copyOf(elements, (int)(size * 1.5));
        }

        this.elements[this.size++] = element;
    }

    /**
     * @return                     Remove e devolve o elemento no topo da Stack.
     * @throws EmptyStackException Devolve uma string quando a Stack estiver vazia.
     */
    @Override
    public T pop() throws EmptyStackException {
        if(this.size == 0) throw new EmptyStackException();

        T elem = this.elements[this.size - 1];
        this.elements[this.size - 1] = null; //Q: Strictly necessary? Why is it a good idea?
        this.size--;

        return elem;
    }

    /**
     * @return                     Devolve, sem remover, o elemento no topo da Stack.
     * @throws EmptyStackException Devolve uma string quando a Stack estiver vazia.
     */
    @Override
    public T peek() throws EmptyStackException {
        return this.elements[this.size - 1];
    }

    /**
     * @return Devolve o tamanho (Nrº de Elementos) atual da Stack.
     */
    @Override
    public int size() {
        return (int)Arrays.stream(this.elements).filter(Objects::isNull).count();
    }

    /**
     * @return Devolve um valor lógico (true/false) se a Stack for vazia ou não.
     */
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Devolve um valor lógico (true/false) que indica se a Stack está vazia ou não.
     */
    @Override
    public void clear() {
        this.size = 0;
    }
}
