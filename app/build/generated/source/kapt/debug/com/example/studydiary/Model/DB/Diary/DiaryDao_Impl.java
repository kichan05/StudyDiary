package com.example.studydiary.Model.DB.Diary;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.studydiary.Model.Diary;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DiaryDao_Impl implements DiaryDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Diary> __insertionAdapterOfDiary;

  private final EntityDeletionOrUpdateAdapter<Diary> __deletionAdapterOfDiary;

  private final EntityDeletionOrUpdateAdapter<Diary> __updateAdapterOfDiary;

  public DiaryDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfDiary = new EntityInsertionAdapter<Diary>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `diary` (`_id`,`focus`,`ability`,`subject`,`method`,`content`,`year`,`month`,`day`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Diary value) {
        stmt.bindLong(1, value.get_id());
        stmt.bindLong(2, value.getFocus());
        stmt.bindLong(3, value.getAbility());
        if (value.getSubject() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getSubject());
        }
        if (value.getMethod() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getMethod());
        }
        if (value.getContent() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getContent());
        }
        stmt.bindLong(7, value.getYear());
        stmt.bindLong(8, value.getMonth());
        stmt.bindLong(9, value.getDay());
      }
    };
    this.__deletionAdapterOfDiary = new EntityDeletionOrUpdateAdapter<Diary>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `diary` WHERE `_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Diary value) {
        stmt.bindLong(1, value.get_id());
      }
    };
    this.__updateAdapterOfDiary = new EntityDeletionOrUpdateAdapter<Diary>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `diary` SET `_id` = ?,`focus` = ?,`ability` = ?,`subject` = ?,`method` = ?,`content` = ?,`year` = ?,`month` = ?,`day` = ? WHERE `_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Diary value) {
        stmt.bindLong(1, value.get_id());
        stmt.bindLong(2, value.getFocus());
        stmt.bindLong(3, value.getAbility());
        if (value.getSubject() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getSubject());
        }
        if (value.getMethod() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getMethod());
        }
        if (value.getContent() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getContent());
        }
        stmt.bindLong(7, value.getYear());
        stmt.bindLong(8, value.getMonth());
        stmt.bindLong(9, value.getDay());
        stmt.bindLong(10, value.get_id());
      }
    };
  }

  @Override
  public void insert(final Diary... diary) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfDiary.insert(diary);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Diary diary) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfDiary.handle(diary);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Diary diary) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfDiary.handle(diary);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Diary[] getAll() {
    final String _sql = "SELECT * FROM diary";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "_id");
      final int _cursorIndexOfFocus = CursorUtil.getColumnIndexOrThrow(_cursor, "focus");
      final int _cursorIndexOfAbility = CursorUtil.getColumnIndexOrThrow(_cursor, "ability");
      final int _cursorIndexOfSubject = CursorUtil.getColumnIndexOrThrow(_cursor, "subject");
      final int _cursorIndexOfMethod = CursorUtil.getColumnIndexOrThrow(_cursor, "method");
      final int _cursorIndexOfContent = CursorUtil.getColumnIndexOrThrow(_cursor, "content");
      final int _cursorIndexOfYear = CursorUtil.getColumnIndexOrThrow(_cursor, "year");
      final int _cursorIndexOfMonth = CursorUtil.getColumnIndexOrThrow(_cursor, "month");
      final int _cursorIndexOfDay = CursorUtil.getColumnIndexOrThrow(_cursor, "day");
      final Diary[] _result = new Diary[_cursor.getCount()];
      int _index = 0;
      while(_cursor.moveToNext()) {
        final Diary _item;
        final int _tmp_id;
        _tmp_id = _cursor.getInt(_cursorIndexOfId);
        final int _tmpFocus;
        _tmpFocus = _cursor.getInt(_cursorIndexOfFocus);
        final int _tmpAbility;
        _tmpAbility = _cursor.getInt(_cursorIndexOfAbility);
        final String _tmpSubject;
        if (_cursor.isNull(_cursorIndexOfSubject)) {
          _tmpSubject = null;
        } else {
          _tmpSubject = _cursor.getString(_cursorIndexOfSubject);
        }
        final String _tmpMethod;
        if (_cursor.isNull(_cursorIndexOfMethod)) {
          _tmpMethod = null;
        } else {
          _tmpMethod = _cursor.getString(_cursorIndexOfMethod);
        }
        final String _tmpContent;
        if (_cursor.isNull(_cursorIndexOfContent)) {
          _tmpContent = null;
        } else {
          _tmpContent = _cursor.getString(_cursorIndexOfContent);
        }
        final int _tmpYear;
        _tmpYear = _cursor.getInt(_cursorIndexOfYear);
        final int _tmpMonth;
        _tmpMonth = _cursor.getInt(_cursorIndexOfMonth);
        final int _tmpDay;
        _tmpDay = _cursor.getInt(_cursorIndexOfDay);
        _item = new Diary(_tmp_id,_tmpFocus,_tmpAbility,_tmpSubject,_tmpMethod,_tmpContent,_tmpYear,_tmpMonth,_tmpDay);
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
  public Diary[] getDay(final int year, final int month, final int day) {
    final String _sql = "SELECT * FROM diary WHERE year = ? and month = ? and day = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, year);
    _argIndex = 2;
    _statement.bindLong(_argIndex, month);
    _argIndex = 3;
    _statement.bindLong(_argIndex, day);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "_id");
      final int _cursorIndexOfFocus = CursorUtil.getColumnIndexOrThrow(_cursor, "focus");
      final int _cursorIndexOfAbility = CursorUtil.getColumnIndexOrThrow(_cursor, "ability");
      final int _cursorIndexOfSubject = CursorUtil.getColumnIndexOrThrow(_cursor, "subject");
      final int _cursorIndexOfMethod = CursorUtil.getColumnIndexOrThrow(_cursor, "method");
      final int _cursorIndexOfContent = CursorUtil.getColumnIndexOrThrow(_cursor, "content");
      final int _cursorIndexOfYear = CursorUtil.getColumnIndexOrThrow(_cursor, "year");
      final int _cursorIndexOfMonth = CursorUtil.getColumnIndexOrThrow(_cursor, "month");
      final int _cursorIndexOfDay = CursorUtil.getColumnIndexOrThrow(_cursor, "day");
      final Diary[] _result = new Diary[_cursor.getCount()];
      int _index = 0;
      while(_cursor.moveToNext()) {
        final Diary _item;
        final int _tmp_id;
        _tmp_id = _cursor.getInt(_cursorIndexOfId);
        final int _tmpFocus;
        _tmpFocus = _cursor.getInt(_cursorIndexOfFocus);
        final int _tmpAbility;
        _tmpAbility = _cursor.getInt(_cursorIndexOfAbility);
        final String _tmpSubject;
        if (_cursor.isNull(_cursorIndexOfSubject)) {
          _tmpSubject = null;
        } else {
          _tmpSubject = _cursor.getString(_cursorIndexOfSubject);
        }
        final String _tmpMethod;
        if (_cursor.isNull(_cursorIndexOfMethod)) {
          _tmpMethod = null;
        } else {
          _tmpMethod = _cursor.getString(_cursorIndexOfMethod);
        }
        final String _tmpContent;
        if (_cursor.isNull(_cursorIndexOfContent)) {
          _tmpContent = null;
        } else {
          _tmpContent = _cursor.getString(_cursorIndexOfContent);
        }
        final int _tmpYear;
        _tmpYear = _cursor.getInt(_cursorIndexOfYear);
        final int _tmpMonth;
        _tmpMonth = _cursor.getInt(_cursorIndexOfMonth);
        final int _tmpDay;
        _tmpDay = _cursor.getInt(_cursorIndexOfDay);
        _item = new Diary(_tmp_id,_tmpFocus,_tmpAbility,_tmpSubject,_tmpMethod,_tmpContent,_tmpYear,_tmpMonth,_tmpDay);
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
