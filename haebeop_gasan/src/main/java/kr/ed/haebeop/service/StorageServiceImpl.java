package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.Storage;
import kr.ed.haebeop.persistence.StorageMapper;
import kr.ed.haebeop.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageServiceImpl implements StorageService{
    @Autowired
    StorageMapper storageMapper;

    @Override
    public List<Storage> storageList() {
        return storageMapper.storageList();
    }

    @Override
    public Storage storageGet(int storageNo) {
        return storageMapper.storageGet(storageNo);
    }

    @Override
    public void storageInsert(Storage storage) {
        storageMapper.storageInsert(storage);
    }

    @Override
    public void storageDelete(int storageNo) {
        storageMapper.storageDelete(storageNo);
    }

    @Override
    public int storageCount() {
        return storageMapper.storageCount();
    }

    @Override
    public void storageUpdate(Storage storage) {
        storageMapper.storageUpdate(storage);
    }


    @Override
    public int storageRecentNo() {
        return storageMapper.storageRecentNo();
    }

    @Override
    public List<Storage> storageBoardList(Storage storage) {
        return storageMapper.storageBoardList(storage);
    }
    @Override
    public Storage storageBoardGet(Storage storage) {
        return storageMapper.storageBoardGet(storage);
    }
}
