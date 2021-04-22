package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/

public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    private Entry<String> root;
    private transient ArrayList <Entry<String>> queue;
    /**
     * root инициализируется по умолчанию, и становится первым элементом обозначенным как
     * "новый корневой элемент для текущего уровня дерева";
     * newLineRootElement - всегда крайний левый нижний элемент дерева.
     */
    public CustomTree() {
        root = new Entry<String>(null);
        root.newLineRootElement = true;
        root.lineNumber = 0;
    }



    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() { //возвращает текущее количество элементов в дереве.
        setValidCollection();
        return queue.size();
    }

    /**
     * Метод getParent принимает значение String value,
     * ищет в древе Entry c значением elementName эквивалентным
     * значению value, и возвращает значение elementName у найденного Entry (Entry.parent)
     *
     * @param value elementName переданного Entry
     * @return parent.elementName найденного Entry (Entry.parent)
     */

    public String getParent(String value) {
        setValidCollection();
        String s = null;
        for (Entry<String> entry : queue) {
            if (entry.lineNumber!=1) {
                if (entry.elementName.equals(value)){
                    s = entry.parent.elementName;
                    break;
                }
            }
        }
        return s;
    }

    /**
     * Метод setValidCollection записывает полную коллекцию элементов дерева,
     * а затем удаляет 1 элемент коллекции, который является изначальным корнем.
     * Используется в методах remove и т.д. для валидного прохода по коллекции.
     */
    private void setValidCollection() {
        setUpCollectoin(root);
        queue.remove(0);
    }


    /**
     * Метод setUpCollection проходит по дереву, начиная с элемента Entry<String> root
     * и перезаписывает все элементы в queue;
     * @param root начальный элемент Entry<String> для вертикального прохода по дереву.
     */
    private void setUpCollectoin(Entry<String> root) {
        queue = new ArrayList<>();
        queue.add(root);
        Queue<Entry<String>> subQueue = new LinkedList<Entry<String>>();
        subQueue.add(root);
     //совершенно непонятно как сорганизованный кусок
        do {
            if (!subQueue.isEmpty()) { //если не пусто
                root = subQueue.poll();
            }
            if (root.leftChild != null) {
                queue.add(root.leftChild);
                subQueue.add(root.leftChild);
            }
            if (root.rightChild != null) {
                queue.add(root.rightChild);
                subQueue.add(root.rightChild);
            }
        } while (!subQueue.isEmpty()); //пока не пусто

    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    /**
     * Метод add добавляет элемент в дерево.
     * Сначала устанавливается полная коллекция элементов, потом происходит итерация по элементам.
     * При итерации каждый элемент проверяется методом checkChildren на возможность иметь
     * ветви. isAvailableToAddChildren() возвращает true если такая возможность имеется;
     * После чего создается и инициализируется новый элемент Entry<String>, добавляется в коллекцию.
     * После чего коллекция заного проверяется и инициализируется с помощью setValidCollection();
     * Если после прохода по всей коллекции ни один элемент не способен иметь новые ветви, это означает, что все
     * вершины обрезаны. Тогда происходит повторная итерация по коллекции с целью поиска элемента с boolean флагом
     * newLineRootElement; Найденный элемент и все последующие элементы в коллекции восстанавливают возможность
     * иметь потомков;
     *
     * @param s строка (String) которую необходимо добавить в коллекцию;
     * @return true после добавления нового элемента;
     */
    @Override
    public boolean add (String s){
        setUpCollectoin(root);
        for (Entry<String> entry : queue){
            entry.checkChildren();
            if (entry.isAvailableToAddChildren()) {
                creatChild(entry, s);
                setValidCollection();
                return true;
            }
        }
        
        boolean reAddingChildren = false;
        for(Entry<String> entry : queue){
            if (entry.newLineRootElement) {
                reAddingChildren = true;
            }
            if (reAddingChildren) {
                entry.availableToAddLeftChildren = true;
                entry.availableToAddRightChildren = true;
            }
        }
        return add(s);
    }

    /**
     * Метод createChild создает новый элемент Entry<String> 
     *     и устанавливает значение переменной parent
     *
     * @param parent родительский элемент Entry<String>;
     * @param s      значение elementName для нового элемента Entry<String>;
     */
    private void creatChild(Entry<String> parent, String s) {
        Entry<String> newOne = new Entry<String>(s);
        newOne.parent = parent;
        newOne.lineNumber = parent.lineNumber+1;
        setChild(parent, newOne);
    }

    /**
     * Метод setChild присваивает переменным left/rightChild родителя ссылку на элемент 
     * Entry<String> child;
     * Если переменная newLineRootElement родителя имела значение true, 
     * то это значение передастся ребенку, у родителя изменится на false;
     * @param parent родительский элемент Entry<String>
     * @param child  элемент-потомок Entry<String>
     */
    private void setChild(Entry<String> parent, Entry<String> child) {
        if (parent.availableToAddLeftChildren){
            parent.leftChild = child;
            parent.availableToAddLeftChildren = false;
            if (parent.newLineRootElement){
                List<Entry<String>> list = getNewLineRootElementsCollection(parent);
                for (Entry<String> entry : list) {
                    entry.newLineRootElement = false;
                }
                child.newLineRootElement = true;
            }
        } else {
            parent.rightChild = child;
            parent.availableToAddRightChildren = false;
            if (parent.newLineRootElement) {
                List<Entry<String>> list = getNewLineRootElementsCollection(parent);
                for (Entry<String> entry : list) {
                    entry.newLineRootElement = false;
                }
                child.newLineRootElement = true;
            }
        }
    }

    /**
     * Доп. метод для подстраховки. При удалении иногда получается 2 элемента newLineRootElement;
     * Этот метод собирает вертикально все такие элементы и снимает флаги newLineRootElement;
     *
     * @param entry Entry<String> со значением true переменной newLineRootElement, которая подлежит
     *              изменению;
     * @return список начиная с Entry<String> entry и заканчивая всеми его parent со значением true
     * переменной newLineRootElement, которая подлежит изменению;
     */
    private List<Entry<String>> getNewLineRootElementsCollection(Entry<String> entry) {
        ArrayList<Entry<String>> list = new ArrayList<>();
        list.add(entry);

        if ((entry.parent != null) && (entry.parent.newLineRootElement)) {
            list.addAll(getNewLineRootElementsCollection(entry.parent));
        }
        return list;
    }


    @Override
    public void add(int index, String element) {

        throw new UnsupportedOperationException();
    }
    /**
     * Если ! о instanceof String throws UnsupportedOperationException();
     * Удаляет первый найденный в дереве элемент Entry<String> со значением параметра elementName
     * эквивалентного o и, в случае успеха возвращает true. Если элемент не найден возвращается false;
     *
     * @param o значение строки подлежащей удалению из дерева.
     * @return Если элемент найден и удален возвращается true, иначе false;
     */
    public boolean remove(Object o) {
        if (!(o instanceof String)) {
            throw new UnsupportedOperationException();
        }
        String value= (String) o;
        setValidCollection();
        for (int i = 0; i < queue.size(); i++) {
            Entry<String> entry = queue.get(i);
            if (entry.elementName.equals(value)) {
                List<Entry<String>> list = getCollection(entry);
                for (Entry<String> stringEntry : list) {
                    if (stringEntry.newLineRootElement) {
                        changeNewLineRootElement(stringEntry, list);
                    }
                }
                if (entry.parent.leftChild == entry) {
                    entry.parent.leftChild = null;
                    setValidCollection();
                    return true;
                } else {
                    entry.parent.rightChild = null;
                    setValidCollection();
                    return true;
                }

            }
        }
        return false;
    }

    /**
     * Метод changeNewLineRootElement меняет boolean флаг newLineRootElement e элементов,
     * подлежащих удалению.
     * Новый элемент ищется по принципу: если остались элементы справа, то выбирается соседний, если не осталось,то поднимаемся на уровень выше и ищем там самый левый.
     *
     * @param entry   Entry<String> текущий элемент являющийся newLineRootElement;
     * @param delList список элементов коллекции Entry<String> подлежащий удалению;
     */
    private void changeNewLineRootElement(Entry<String> entry, List<Entry<String>> delList) {
        setValidCollection();
        int size = size();
        for (int i = 0; i < size; i++) {
            Entry<String> newEntry = queue.get(i);
            if (newEntry == entry) {
                if (i < size - 1) {
                    newEntry.newLineRootElement = false;
                    for (int k = i + 1; k < size; k++) {
                        Entry<String> newRootEntry = queue.get(k);
                        if (!delList.contains(newRootEntry)) {
                            newRootEntry.newLineRootElement = true;
                            break;
                        }
                    }
                    //Если все элементы справа подлежат удалению идем вверх по дереву:
                    Entry<String> element = getUndelRoot(newEntry.parent, delList);
                    element.newLineRootElement = true;
                    break;
                } else {
                    newEntry.newLineRootElement = false;
                    Entry<String> element = getUndelRoot(newEntry.parent, delList);
                    element.newLineRootElement = true;
                    break;
                }
            }
        }
    }

    /**
     * Метод getUndelRoot ищет вертикально и горизонтально первый элемент Entry<String> не входящий в лист delList
     * (список элементов подлежащих удалению);
     *
     * @param entry   начальный элемент Entry<String> от которого начинается поиск;
     * @param delList список элементов подлежащих удалению
     * @return первый найденный верхний левый элемент Entry<String> не входящий в delList;
     */
    private Entry<String> getUndelRoot(Entry<String> entry, List<Entry<String>> delList) {
        for (Entry<String> element : queue) {
            if (element.lineNumber == entry.lineNumber) {
                if (!delList.contains(element)) {
                    return element;
                }
            }
        }
        if (entry.lineNumber == 0) {   // Дошли до root и возвращаем его.
            return entry;
        }
        return getUndelRoot(entry.parent, delList);
    }


    /**
     * Метод  getCollection отличается от метода setUpCollection только тем,
     * что возвращает полученную коллекцию;
     *
     * @param entry начальный элемент Entry<String> для вертикального прохода по дереву.
     * @return полученную коллекцию (List<Entry<String>>) элементов дерева.
     */
    private List<Entry<String>> getCollection(Entry<String> entry) {
        ArrayList<Entry<String>> list = new ArrayList<>();
        Queue<Entry<String>> subQueue = new LinkedList<Entry<String>>();
        list.add(entry);
        subQueue.add(entry);
        do {
            if (!subQueue.isEmpty()) {
                entry = subQueue.poll();
            }
            if (entry.leftChild != null) {
                list.add(entry.leftChild);
                subQueue.add(entry.leftChild);
            }
            if (entry.rightChild != null) {
                list.add(entry.rightChild);
                subQueue.add(entry.rightChild);
            }
        } while (!subQueue.isEmpty());
        return list;
    }

    @Override
    public String remove(int index) {

        throw new UnsupportedOperationException();
    }
    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }
    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }
    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    static class Entry<T> implements Serializable {
        int lineNumber;
        String elementName;
        boolean availableToAddLeftChildren = true;
        boolean availableToAddRightChildren = true;
        boolean newLineRootElement;
        Entry<T> parent;
        Entry leftChild;
        Entry rightChild;


        private Entry(String name) {
            elementName = name;
            newLineRootElement = false;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }



        public void checkChildren() {
            if (this.leftChild != null) {
                availableToAddLeftChildren = false;
            }
            if (this.rightChild != null) {
                availableToAddRightChildren = false;
            }
        }

        public boolean isAvailableToAddChildren (){
            return this.availableToAddLeftChildren || this.availableToAddRightChildren;
        }
    }
}


/*Требования:
1. После удаления последнего добавленного элемента из дерева с помощью метода remove, метод size должен возвращать N-1.
2. После удаления второго элемента добавленного в дерево, метод size должен возвращать N/2 + 1 (для случаев где N > 2 и является степенью двойки), N - размер дерева до удаления.
3. Если переданный объект не является строкой, метод remove() должен бросить UnsupportedOperationException.
4. Если ни один элемент не способен иметь потомков, необходимо восстановить такую возможность.*/