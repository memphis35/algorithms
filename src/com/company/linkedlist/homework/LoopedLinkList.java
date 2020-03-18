package com.company.linkedlist.homework;

import com.company.exceptions.EmptyListException;
import com.company.linkedlist.linklist.Link;

/**
 * @homework 5.3. Циклическим списком называется связанный список, в котором последний
 * элемент содержит ссылку на первый элемент. Существует много способов реализа-
 * ции циклических списков. Иногда объект списка содержит указатель на «начало»
 * списка. Однако в этом случае список уже не похож на замкнутый круг, а больше
 * напоминает обычный список, у которого конец связан с началом. Создайте класс
 * для односвязного списка, не имеющий ни начала, ни конца. Доступ к списку осу-
 * ществляется по единственной ссылке current, которая может указывать на любой
 * элемент списка. Ссылка перемещается по списку так, как требуется пользователю
 * (ситуация, для которой идеально подходит циклический список, представлена
 * в проекте 5.5). Список должен поддерживать операции вставки, поиска и удаления.
 * Вероятно, удобнее выполнять эти операции с элементом, следующим за тем, на
 * который указывает current. (Так как список является односвязным, вы не сможе-
 * те вернуться к предыдущему элементу без полного прохождения всей цепочки.)
 * Также следует предусмотреть возможность вывода содержимого списка (хотя его
 * придется разбить в некоторой точке для вывода на экран). Метод step(), который
 * перемещает current к следующему элементу, тоже может пригодиться.
 */
public class LoopedLinkList {

    private Link current;

    public void setCurrent(Link current) {
        this.current = current;
    }

    Link getCurrent() {
        return current;
    }

    public void insert(String data) {
        Link element = new Link(data);
        if (isEmpty()) {
            element.setNext(element);
            current = element;
        } else {
            element.setNext(current.getNext());
            current.setNext(element);
        }
    }

    public void next() {
        if (current.getNext() != null) {
            current = current.getNext();
        }
    }

    public Link delete() throws EmptyListException {
        Link result = current.getNext();
        if (!isOnlyOne()) {
            current.setNext(current.getNext().getNext());
        } else {
            current = null;
        }
        result.setNext(null);
        return result;
    }

    private boolean isEmpty() {
        return current == null;
    }

    public void clear() {
        while (current != null) {
            delete();
        }
    }

    private boolean isOnlyOne() {
        return current.equals(current.getNext());
    }

    public static void main(String[] args) {
        LoopedLinkList example = new LoopedLinkList();
        example.insert("Mike");
        example.insert("Alex");
        example.insert("Fiona");
        example.insert("Shaun");
        example.insert("Emily");
        System.out.println(example.getCurrent().getData());
        while (!example.isEmpty()) {
            System.out.println(example.delete().getData());
        }
    }

}
