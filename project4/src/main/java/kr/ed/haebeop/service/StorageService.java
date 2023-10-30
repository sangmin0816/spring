package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.Storage;


import java.util.List;


public interface StorageService {
    public List<Storage> storageList();
    public Storage storageGet(int fileNo);
    public int storageCount();
    public void storageInsert(Storage storage);
    public void storageUpdate(Storage storage);
    public void storageDelete(int fileNo);


    public int storageRecentNo();
    public List<Storage> storageBoardList(Storage storage);
    public Storage storageBoardGet(Storage storage);
}
