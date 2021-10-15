package com.example.studydiary.Model.DB.Method;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.studydiary.Model.Method;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MethodDao_Impl implements MethodDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Method> __insertionAdapterOfMethod;

  private final EntityDeletionOrUpdateAdapter<Method> __deletionAdapterOfMethod;

  private final EntityDeletionOrUpdateAdapter<Method> __updateAdapterOfMethod;

  private final SharedSQLiteStatement __preparedStmtOfClearAll;

  public MethodDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMethod = new EntityInsertionAdapter<Method>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `study_method` (`_id`,`name`,`explanation`,`subject`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Method value) {
        stmt.bindLong(1, value.get_id());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getExplanation() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getExplanation());
        }
        if (value.getSubject() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getSubject());
        }
      }
    };
    this.__deletionAdapterOfMethod = new EntityDeletionOrUpdateAdapter<Method>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `study_method` WHERE `_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Method value) {
        stmt.bindLong(1, value.get_id());
      }
    };
    this.__updateAdapterOfMethod = new EntityDeletionOrUpdateAdapter<Method>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `study_method` SET `_id` = ?,`name` = ?,`explanation` = ?,`subject` = ? WHERE `_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Method value) {
        stmt.bindLong(1, value.get_id());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getExplanation() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getExplanation());
        }
        if (value.getSubject() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getSubject());
        }
        stmt.bindLong(5, value.get_id());
      }
    };
    this.__preparedStmtOfClearAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM study_method";
        return _query;
      }
    };
  }

  @Override
  public void insert(final Method... method) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfMethod.insert(method);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Method method) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfMethod.handle(method);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Method method) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfMethod.handle(method);
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
  public Method[] getAll() {
    final String _sql = "SELECT * FROM study_method";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "_id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfExplanation = CursorUtil.getColumnIndexOrThrow(_cursor, "explanation");
      final int _cursorIndexOfSubject = CursorUtil.getColumnIndexOrThrow(_cursor, "subject");
      final Method[] _result = new Method[_cursor.getCount()];
      int _index = 0;
      while(_cursor.moveToNext()) {
        final Method _item;
        final int _tmp_id;
        _tmp_id = _cursor.getInt(_cursorIndexOfId);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final String _tmpExplanation;
        if (_cursor.isNull(_cursorIndexOfExplanation)) {
          _tmpExplanation = null;
        } else {
          _tmpExplanation = _cursor.getString(_cursorIndexOfExplanation);
        }
        final String _tmpSubject;
        if (_cursor.isNull(_cursorIndexOfSubject)) {
          _tmpSubject = null;
        } else {
          _tmpSubject = _cursor.getString(_cursorIndexOfSubject);
        }
        _item = new Method(_tmp_id,_tmpName,_tmpExplanation,_tmpSubject);
        _result[_index] = _item;
        _index ++;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Method[] getSubject(final String subject) {
    final String _sql = "SELECT * FROM study_method WHERE subject = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (subject == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, subject);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "_id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfExplanation = CursorUtil.getColumnIndexOrThrow(_cursor, "explanation");
      final int _cursorIndexOfSubject = CursorUtil.getColumnIndexOrThrow(_cursor, "subject");
      final Method[] _result = new Method[_cursor.getCount()];
      int _index = 0;
      while(_cursor.moveToNext()) {
        final Method _item;
        final int _tmp_id;
        _tmp_id = _cursor.getInt(_cursorIndexOfId);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final String _tmpExplanation;
        if (_cursor.isNull(_cursorIndexOfExplanation)) {
          _tmpExplanation = null;
        } else {
          _tmpExplanation = _cursor.getString(_cursorIndexOfExplanation);
        }
        final String _tmpSubject;
        if (_cursor.isNull(_cursorIndexOfSubject)) {
          _tmpSubject = null;
        } else {
          _tmpSubject = _cursor.getString(_cursorIndexOfSubject);
        }
        _item = new Method(_tmp_id,_tmpName,_tmpExplanation,_tmpSubject);
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
