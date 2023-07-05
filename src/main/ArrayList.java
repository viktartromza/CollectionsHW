package main;


import java.util.Comparator;

/**
 * Вариант реализации Коллекции, основанный на хранении данных
 * в динамическом массиве
 */
public class ArrayList<E> {
    private E[] elementData;
    private int size;
    private static final int INIT_CAPACITY = 10;

    /**
     * Конструктор без параметров создает массив с начальной емкостью 10
     */
    public ArrayList() {
        this.elementData = (E[]) new Object[INIT_CAPACITY];
    }

    /**
     * Добавление элемента проводится в конец (согласно значению size) массива. Перед добавлением проводится
     * проверка емкости массива и ее увеличение при необходимости
     */
    public void add(E item) {
        if (size == elementData.length - 1) {
            ensureCapacity(elementData.length * 3 / 2 + 1);
        }
        elementData[size++] = item;
    }

    /**
     * Добавление элемента с указанием индекса проводится после подготовки места для нового элемента. Перед
     * добавлением проводится проверка емкости массива и ее увеличение при необходимости
     */
    public void add(int index, E item) {
        if (size == elementData.length - 1) {
            ensureCapacity(elementData.length * 3 / 2 + 1);
        }
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = item;
        size++;
    }

    /**
     * Метод увеличения емкости внутреннего массива, принимающий в качестве праметра новую емкость
     */
    public void ensureCapacity(int newCapacity) {
        E[] newArray = (E[]) new Object[newCapacity];
        System.arraycopy(elementData, 0, newArray, 0, size);
        elementData = newArray;
    }

    /**
     * Возвращает элемент с заданным индексом
     */
    public E get(int index) {
        return elementData[index];
    }

    /**
     * Возвращает длину коллекции
     */
    public int size() {
        return this.size;
    }

    /**
     * Возвращает true, если коллекция не содержит элементов
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Удаление элемента по индексу. Не уменьшает емкость внутреннего массива
     */
    public void remove(int index) {
        int numMoved = size - index - 1;
        System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        elementData[--size] = null;
    }

    /**
     * Удаление заданного элемента. Удаляется первый найденный заданный элемент.  Не уменьшает емкость внутреннего
     * массива
     */
    public void remove(E item) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(item)) {
                remove(i);
                break;
            }
        }
    }

    /**
     * Возвращает первое значение индекса заданного элемента. В случае отсутствия заданного элемента возвращает -1
     */
    public int indexOf(E item) {
        int indexOf = -1;
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(item)) {
                indexOf = i;
                break;
            }
        }
        return indexOf;
    }

    /**
     * Возвращает true, если коллекция содержит заданный в качестве параметра элемент
     */
    public boolean contains(E item) {
        return indexOf(item) >= 0;
    }

    /**
     * Возвращает новую коллекцию, отсортированную в порядке возрастания элементов. Способ сортировки - быстрая
     * сортировка
     */
    public ArrayList<E> quickSort(Comparator<? super E> c) {
        if (this.size() < 2) {
            return this;
        } else {
            E pivot = this.get(0);
            ArrayList<E> less = new ArrayList<>();
            ArrayList<E> greater = new ArrayList<>();
            ArrayList<E> result = new ArrayList<>();
            for (int i = 1; i < this.size(); i++) {
                E item = this.get(i);
                if (c.compare(item, pivot) <= 0) {
                    less.add(item);
                } else {
                    greater.add(item);
                }
            }
            for (int i = 0; i < less.size(); i++) {
                result.add(less.quickSort(c).get(i));
            }
            result.add(pivot);
            for (int i = 0; i < greater.size(); i++) {
                result.add(greater.quickSort(c).get(i));
            }
            return result;
        }
    }
}
