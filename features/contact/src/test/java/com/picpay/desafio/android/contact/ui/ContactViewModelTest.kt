package com.picpay.desafio.android.contact.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.picpay.desafio.android.contact.ui.ContactFactory.CONTACT
import com.picpay.desafio.android.contact.ui.ContactViewAction.*
import com.picpay.desafio.android.contact.ui.ContactViewAction.Set
import com.picpay.desafio.android.contact.usecase.GetContactsUseCase
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.*
import org.junit.Assert.*
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module

internal class ContactViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var viewModel: ContactViewModel
    private lateinit var action: (ContactViewAction) -> Unit
    private val navigation: ContactNavigation = mockk()
    private val getContacts: GetContactsUseCase = mockk()
    private val stub = ContactStub(getContacts)
    private val moduleTest = module {
        single { navigation }
        single { getContacts }
    }

    @Before
    fun setup() {
        MockKAnnotations.init()
        startKoin { modules(moduleTest) }
        viewModel = ContactViewModel()
        action = viewModel::dispatchAction
    }

    @After
    fun reset() {
        stopKoin()
    }

    @Test
    fun `WHEN dispatch Clear_Error_Unexpected action MUST set unexpectedError as null`() {
        action(Clear.Error.Unexpected)

        assertNull(viewModel.viewState.unexpectedError)
    }

    @Test
    fun `WHEN dispatch Get_Contacts action and had SUCCESS MUST set contacts`() {
        stub.success()

        action(Get.Contacts)

        assertFalse(viewModel.viewState.isLoading)
        assertNull(viewModel.viewState.unexpectedError)
        assertTrue(viewModel.viewState.contacts.isNotEmpty())
    }

    @Test
    fun `WHEN dispatch Get_Contacts action and had FAILURE MUST set unexpectedError`() {
        stub.failure()

        action(Get.Contacts)

        assertFalse(viewModel.viewState.isLoading)
        assertNotNull(viewModel.viewState.unexpectedError)
        assertTrue(viewModel.viewState.contacts.isEmpty())
    }

    @Test
    fun `WHEN dispatch Navigate_Details action MUST call navigation once`() {
        every { navigation.test(any()) } returns Unit

        action(Navigate.Details(CONTACT))

        verify(exactly = 1) { navigation.test(any()) }
    }

    @Test
    fun `WHEN dispatch Navigate_PopBackStack action MUST call navigation once`() {
        every { navigation.popBackStack() } returns Unit

        action(Navigate.PopBackStack)

        verify(exactly = 1) { navigation.popBackStack() }
    }

    @Test
    fun `WHEN dispatch Set_Initialization action MUST set isInitialized as true`() {
        action(Set.Initialization)

        assertTrue(viewModel.viewState.isInitialized)
    }
}
