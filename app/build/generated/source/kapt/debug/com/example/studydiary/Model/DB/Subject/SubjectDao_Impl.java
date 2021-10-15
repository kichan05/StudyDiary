package com.example.studydiary.Model.DB.Subject;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.studydiary.Model.Subject;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class SubjectDao_Impl implements SubjectDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Subject> __insertionAdapterOfSubject;

  private final EntityDeletionOrUpdateAdapter<Subject> __deletionAdapterOfSubject;

  private final EntityDeletionOrUpdateAdapter<Subject> __updateAdapterOfSubject;

  private final SharedSQLiteStatement __preparedStmtOfClearAll;

  public SubjectDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSubject = new EntityInsertionAdapter<Subject>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `subject` (`_id`,`subject_name`) VALUES (nullif(?, 0),?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Subject value) {
        stmt.bindLong(1, value.get_id());
        if (value.getSubject_name() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getSubject_name());
        }
      }
    };
    this.__deletionAdapterOfSubject = new EntityDeletionOrUpdateAdapter<Subject>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `subject` WHERE `_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Subject value) {
        stmt.bindLong(1, value.get_id());
      }
    };
    this.__updateAdapterOfSubject = new EntityDeletionOrUpdateAdapter<Subject>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `subject` SET `_id` = ?,`subject_name` = ? WHERE `_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Subject value) {
        stmt.bindLong(1, value.get_id());
        if (value.getSubject_name() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getSubject_name());
        }
        stmt.bindLong(3, value.get_id());
      }
    };
    this.__preparedStmtOfClearAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM subject";
        return _query;
      }
    };
  }

  @Override
  public void insert(final Subject... subject) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfSubject.insert(subject);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Subject subject) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfSubject.handle(subject);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Subject subject) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfSubject.handle(subject);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void clearAll() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfClearAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfClearAll.release(_stmt);
    }
  }

  @Override
  public Subject[] getAll() {
    final String _sql = "SELECT * FROM subject";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "_id");
      final int _cursorIndexOfSubjectName = CursorUtil.getColumnIndexOrThrow(_cursor, "subject_name");
      final Subject[] _result = new Subject[_cursor.getCount()];
      int _index = 0;
      while(_cursor.moveToNext()) {
        final Subject _item;
        final int _tmp_id;
        _tmp_id = _cursor.getInt(_cursorIndexOfId);
        final String _tmpSubject_name;
        if (_cursor.isNull(_cursorIndexOfSubjectName)) {
          _tmpSubject_name = null;
        } else {
          _tmpSubject_name = _cursor.getString(_cursorIndexOfSubjectName);
        }
        _item = new Subject(_tmp_id,_tmpSubject_name);
        _result[_index] = _item;
        _index ++;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
