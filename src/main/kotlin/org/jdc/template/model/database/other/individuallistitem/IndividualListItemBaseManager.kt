/*
 * IndividualListItemBaseManager.kt
 *
 * GENERATED FILE - DO NOT EDIT
 * 
 */



package org.jdc.template.model.database.other.individuallistitem

import org.jdc.template.model.database.DatabaseManager
import org.dbtools.android.domain.database.DatabaseWrapper
import org.dbtools.android.domain.RxKotlinAndroidBaseManagerWritable
import org.dbtools.android.domain.database.contentvalues.DBToolsContentValues
import org.dbtools.android.domain.AndroidBaseRecord


@Suppress("unused", "ConvertSecondaryConstructorToPrimary")
@SuppressWarnings("all")
abstract class IndividualListItemBaseManager  : RxKotlinAndroidBaseManagerWritable<IndividualListItem> {

     override val allColumns: Array<String> = IndividualListItemConst.ALL_COLUMNS
     override val primaryKey = IndividualListItemConst.PRIMARY_KEY_COLUMN
     override val dropSql = IndividualListItemConst.DROP_TABLE
     override val createSql = IndividualListItemConst.CREATE_TABLE
     override val insertSql = IndividualListItemConst.INSERT_STATEMENT
     override val updateSql = IndividualListItemConst.UPDATE_STATEMENT
     var databaseManager: DatabaseManager

    constructor(databaseManager: DatabaseManager) {
        this.databaseManager = databaseManager
    }

    override fun getDatabaseName() : String {
        return IndividualListItemConst.DATABASE
    }

    override fun newRecord() : IndividualListItem {
        return IndividualListItem()
    }

    override fun getTableName() : String {
        return IndividualListItemConst.TABLE
    }

    override fun getReadableDatabase(@javax.annotation.Nonnull databaseName: String) : DatabaseWrapper<in AndroidBaseRecord, in DBToolsContentValues<*>> {
        return databaseManager.getReadableDatabase(databaseName)
    }

    override fun getWritableDatabase(@javax.annotation.Nonnull databaseName: String) : DatabaseWrapper<in AndroidBaseRecord, in DBToolsContentValues<*>> {
        return databaseManager.getWritableDatabase(databaseName)
    }

    override fun getAndroidDatabase(@javax.annotation.Nonnull databaseName: String) : org.dbtools.android.domain.AndroidDatabase? {
        return databaseManager.getDatabase(databaseName)
    }

    override fun getDatabaseConfig() : org.dbtools.android.domain.config.DatabaseConfig {
        return databaseManager.databaseConfig
    }


}