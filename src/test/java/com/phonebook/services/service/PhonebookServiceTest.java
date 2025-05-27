// package com.phonebook.services.service;

// import static org.junit.jupiter.api.Assertions.*;
// import static org.mockito.Mockito.*;

// import java.util.Date;
// import java.util.Optional;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.junit.jupiter.MockitoExtension;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.PageImpl;
// import org.springframework.data.domain.PageRequest;

// import com.phonebook.services.model.Mst_Phonebook;
// import com.phonebook.services.repo.PhonebookRepository;

// import java.util.Arrays;

// @ExtendWith(MockitoExtension.class)
// public class PhonebookServiceTest {

//     @Mock
//     private PhonebookRepository phonebookRepository;

//     @InjectMocks
//     private PhonebookService phonebookService;

//     private Mst_Phonebook testPhonebook;

//     @BeforeEach
//     void setUp() {
//         testPhonebook = new Mst_Phonebook();
//         testPhonebook.setId(1L);
//         testPhonebook.setDelete_flag(0);
//         testPhonebook.setActive_flg(1);
//     }

//     @Test
//     void testSave() {
//         when(phonebookRepository.save(any(Mst_Phonebook.class))).thenReturn(testPhonebook);

//         Mst_Phonebook result = phonebookService.save(testPhonebook);

//         assertNotNull(result);
//         assertEquals(testPhonebook.getId(), result.getId());
//         verify(phonebookRepository).save(testPhonebook);
//     }

//     @Test
//     void testGet() {
//         when(phonebookRepository.findByIdSubject(1L)).thenReturn(testPhonebook);

//         Mst_Phonebook result = phonebookService.get(1L);

//         assertNotNull(result);
//         assertEquals(testPhonebook.getId(), result.getId());
//         verify(phonebookRepository).findByIdSubject(1L);
//     }

//     @Test
//     void testSoftDelete_Success() {
//         when(phonebookRepository.findById(1L)).thenReturn(Optional.of(testPhonebook));
//         when(phonebookRepository.save(any(Mst_Phonebook.class))).thenReturn(testPhonebook);

//         Mst_Phonebook result = phonebookService.softDelete(1L);

//         assertNotNull(result);
//         assertEquals(1, result.getDelete_flag());
//         assertEquals(0, result.getActive_flg());
//         assertNotNull(result.getDelete_date());
//         verify(phonebookRepository).save(testPhonebook);
//     }

//     @Test
//     void testSoftDelete_NotFound() {
//         when(phonebookRepository.findById(1L)).thenReturn(Optional.empty());

//         Mst_Phonebook result = phonebookService.softDelete(1L);

//         assertNull(result);
//         verify(phonebookRepository, never()).save(any());
//     }

//     @Test
//     void testSubjectNextVal() {
//         when(phonebookRepository.subjectNextVal()).thenReturn(2L);

//         Long result = phonebookService.subjectNextVal();

//         assertEquals(2L, result);
//         verify(phonebookRepository).subjectNextVal();
//     }

//     @Test
//     void testSearchPagination_WithEmptyNumber() {
//         Page<Mst_Phonebook> mockPage = new PageImpl<>(Arrays.asList(testPhonebook));
//         PageRequest pageRequest = PageRequest.of(0, 10);
        
//         when(phonebookRepository.search(pageRequest)).thenReturn(mockPage);

//         Page<Mst_Phonebook> result = phonebookService.SearchPagination("", 0, 10);

//         assertNotNull(result);
//         assertEquals(1, result.getTotalElements());
//         verify(phonebookRepository).search(pageRequest);
//     }

//     @Test
//     void testSearchPagination_WithNumber() {
//         Page<Mst_Phonebook> mockPage = new PageImpl<>(Arrays.asList(testPhonebook));
//         PageRequest pageRequest = PageRequest.of(0, 10);
//         String number = "123";
        
//         when(phonebookRepository.searchWithParam("+" + number, pageRequest)).thenReturn(mockPage);

//         Page<Mst_Phonebook> result = phonebookService.SearchPagination(number, 0, 10);

//         assertNotNull(result);
//         assertEquals(1, result.getTotalElements());
//         verify(phonebookRepository).searchWithParam("+" + number, pageRequest);
//     }
// } 