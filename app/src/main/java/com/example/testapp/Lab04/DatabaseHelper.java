package com.example.testapp.Lab04;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "studentDatabase";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "students";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_PHONE = "phone";
    private static final String COLUMN_EMAIL = "email";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        String createTableStatement = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_PHONE + " TEXT, " +
                COLUMN_EMAIL + " TEXT)";
        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public boolean addStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAME, student.getName());
        cv.put(COLUMN_PHONE, student.getPhone());
        cv.put(COLUMN_EMAIL, student.getEmail());

        long insert = db.insert(TABLE_NAME, null, cv);
        return insert != -1;
    }
    public Student getStudentById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String queryString = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + " = " + id;
        Cursor cursor = db.rawQuery(queryString, null);

        Student student = null;
        if (cursor.moveToFirst()) {
            int studentID = cursor.getInt(0);
            String studentName = cursor.getString(1);
            String studentPhone = cursor.getString(2);
            String studentEmail = cursor.getString(3);
            student = new Student();
            student.setId(studentID);
            student.setName(studentName);
            student.setPhone(studentPhone);
            student.setEmail(studentEmail);
        }

        cursor.close();
        db.close();
        return student;
    }
    public List<Student> getStudents() {
        List<Student> returnList = new ArrayList<>();
        String queryString = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            do {
                int studentID = cursor.getInt(0);
                String studentName = cursor.getString(1);
                String studentPhone = cursor.getString(2);
                String studentEmail = cursor.getString(3);
                Student student = new Student();
                student.setId(studentID);
                student.setName(studentName);
                student.setPhone(studentPhone);
                student.setEmail(studentEmail);
                returnList.add(student);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return returnList;
    }
    public boolean deleteStudent(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + " = " + id;

        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            return true;
        } else {
            return false;
        }
    }
    public boolean updateStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAME, student.getName());
        cv.put(COLUMN_PHONE, student.getPhone());
        cv.put(COLUMN_EMAIL, student.getEmail());

        int update = db.update(TABLE_NAME, cv, COLUMN_ID + " = ?", new String[] {String.valueOf(student.getId())});
        return update > 0;
    }


}
