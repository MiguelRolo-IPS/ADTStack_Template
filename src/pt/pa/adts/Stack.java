package pt.pa.adts;

/**
 *  Isto é a Interface "Stack" que especifica o tipo e operações do programa
 *
 * @param <T> tipo de armazenamento genério
 *
 * @author Miguel Rôlo
 * @version %I% %G%
 */

public interface Stack<T>  {
    /**
     * @param element             Tipo de armazenamento genérico
     * @throws FullStackException Apresenta uma mensagem quando
     *                            a Stack estiver cheia.
     */
    public void push(T element) throws FullStackException;

    /**
     * @return Devolve uma string se a Stakc estiver vazia.
     * @throws EmptyStackException Remove e devolve o elemento no topo da Stack.
     */
    public T pop() throws EmptyStackException;

    /**
     * @return Devolve uma string se a Stack estiver vazia.
     * @throws EmptyStackException Devolve, sem remover, o elemento no topo da Stack.
     */
    public T peek() throws EmptyStackException;

    /**
     * @return Devolve o tamanho (nrº de elementos) atual da Stack.
     */
    public int size();

    /**
     * @return Devolve um valor lógico (true/false) que indica se a Stack está vazia ou não.
     */
    public boolean isEmpty();

    /**
     * Descarta todos os elementos da Stack, voltando a estar vazia.
     */
    public void clear();
}