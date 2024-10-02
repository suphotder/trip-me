package com.example.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.server.entity.PhotoEntity;
import com.example.server.entity.TagEntity;
import com.example.server.entity.TripEntity;
import com.example.server.entity.TripTagEntity;
import com.example.server.repository.PhotoRepository;
import com.example.server.repository.TagRepository;
import com.example.server.repository.TripRepository;
import com.example.server.repository.TripTagRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

        private final TripRepository tripRepository;
        private final PhotoRepository photoRepository;
        private final TagRepository tagRepository;
        private final TripTagRepository tripTagRepository;
        private final JdbcTemplate jdbcTemplate;
        private final Logger logger = LogManager.getLogger(DataInitializer.class);

        @Override
        public void run(String... args) throws Exception {
                if (isDatabaseConnected()) {
                        logger.info("Database connected");
                        insertInitialData();
                        logger.info("Initialization data success");
                }
        }

        private void insertInitialData() {
                try {
                        long count = tripRepository.count();
                        if (count == 0) {
                                TripEntity tripEntity1 = new TripEntity();
                                tripEntity1.setTitle("คู่มือเที่ยวเกาะช้าง กิน เที่ยว พักที่ไหนดี? อ่านจบครบที่เดียว!");
                                tripEntity1.setDescription(
                                                "เริ่มจากเพื่อนอยากไปเขาคิชฌกูฏ หลังจากดูรายการทีวี จึงทำให้เกิดทริปนี้ขึ้นแบบเร่งด่วน โดยเดินทางด้วยรถ บขส. ไปยังจันทบุรี และการเดินทางหลักในการเที่ยวคือมอเตอร์ไซค์เช่า");
                                tripEntity1.setUrl("https://www.wongnai.com/trips/travel-koh-chang");

                                TripEntity tripEntity2 = new TripEntity();
                                tripEntity2.setTitle("เที่ยวญี่ปุ่นไปกับภูเขาไฟชื่อดังให้สุดฟินจาก 15 มุมสุดงาม~");
                                tripEntity2.setDescription(
                                                "สายถ่ายรูปห้ามพลาด! ลุยเที่ยวญี่ปุ่น ชมภูเขาไฟฟูจิ ทิวทัศน์รอบทิศหลากมุม งามไม่รู้ลืม");
                                tripEntity2.setUrl("https://www.wongnai.com/trips/views-around-fuji");

                                TripEntity tripEntity3 = new TripEntity();
                                tripEntity3.setTitle(
                                                "เที่ยวฟินแลนด์แบบฟิน ๆ ไปฟาร์ม Husky ขี่ Reindeer เล่น Snowmobile");
                                tripEntity3.setDescription(
                                                "ใครว่าเที่ยวฟินแลนด์ มีแค่ล่าแสงเหนือ กิจกรรมกลางหิมะเค้าก็มีให้ทำเพียบ! ทั้งขี่ Husky, Reindeer ขับเจ็ทสกีหิมะท่ามกลางภูเขาอุณภูมิติดลบ ต้องลองสักครั้งในชีวิต");
                                tripEntity3.setUrl("https://www.wongnai.com/trips/trip-at-finland");

                                TripEntity tripEntity4 = new TripEntity();
                                tripEntity4.setTitle("วังหลวงเนื้อย่าง อ่านต่อได้ที่");
                                tripEntity4.setDescription(
                                                "วังหลวงเนื้อย่าง” ปิ้งย่างสไตล์ญี่ปุ่นแบบฉบับดั้งเดิม สูตรชาววังระดับตำนาน อร่อยสุดเลิศ วัตถุดิบสดใหม่ เนื้อเด็ดคัดพิเศษเกรดคุณภาพ มาแบบจัดเต็ม แถมมาพร้อมด้วยบรรยากาศภายในร้าน ที่ตกแต่งมาในสไตล์ญี่ปุ่นโบราณย้อนยุค แนววินเทจเท่ๆ ให้อารมณ์คล้ายอยู่ในเรียวกังญี่ปุ่น ที่มีให้นั่งในร้านถึง 2 ชั้น");
                                tripEntity4.setUrl(
                                                "https://www.wongnai.com/travel/trips/8cd72c64054344759819b16236407c5b");

                                TripEntity tripEntity5 = new TripEntity();
                                tripEntity5.setTitle("OIKOS - Brunch & Bar");
                                tripEntity5.setDescription(
                                                "อิ-โคส คาเฟ่มินิมอลย่านอารีย์ สวยบรรยากาศดี น่านั่ง ตกแต่งมาในสไตล์ Japanese ผสมสแกนดิเนเวียน ได้บรรยากาศอบอุ่นละมุน ให้อารมณ์ชิลๆเหมือนนั่งอยู่ที่บ้าน คล้องกับชื่อร้าน \"อิโคส\" ที่แปลว่าบ้าน ครอบครัว และการรวมตัวกัน ในภาษากรีก แถมยังให้อารมณ์บรรยากาศฟีลแบบบ้านพักตากอากาศของแถบยุโรปและสแกนดิเนเวียด้วย");
                                tripEntity5.setUrl(
                                                "https://www.wongnai.com/travel/trips/211c8f50221a43d1857d6fbc9099955a");

                                TripEntity tripEntity6 = new TripEntity();
                                tripEntity6.setTitle("Koyama Yakiniku Japanese Restaurant");
                                tripEntity6.setDescription(
                                                "พามาฟินไม่ยั้งกับบุฟเฟ่ต์ปิ้งย่างเตาถ่านสไตล์ญี่ปุ่นแท้ๆ แถมยังจัดเต็มกับเมนูพรีเมียมแบบไม่อั้น!");
                                tripEntity6.setUrl(
                                                "https://www.wongnai.com/travel/trips/a8602871855842bd87c3edebd2b2c3af");

                                TripEntity tripEntity7 = new TripEntity();
                                tripEntity7.setTitle(
                                                "พาเที่ยว “กาญจนบุรี” 2 วัน 1 คืน เก็บทุกไฮไลต์ ลุยไปน้ำตกชั้นเจ็ด!");
                                tripEntity7.setDescription(
                                                "ลุยเที่ยว “กาญจนบุรี” ไปกับแวน เฮ้วซิ่ง เจ้าเก่า เช็กอินที่ต้นจามจุรียักษ์ ชิลจัดกับเขื่อนท่าทุ่งนา ลุยขึ้นน้ำตกเอราวัณ ปิดท้ายทริปสุดปังที่สะพานข้ามแม่น้ำแคว!");
                                tripEntity7.setUrl("https://www.wongnai.com/trips/kanchanaburi-trip-with-vanhelsing");

                                TripEntity tripEntity8 = new TripEntity();
                                tripEntity8.setTitle(
                                                "พาหนุ่มขับรถเที่ยวตัวเมืองกาญจน์ เช็กอินแลนด์มาร์คใหม่ ถ่ายรูปปัง อ่านต่อได้ที่");
                                tripEntity8.setDescription(
                                                "ครั้งนี้ซังและหนุ่มล็อตเต้พากันขับรถตระเวนเมืองกาญจน์แบบจุใจ ที่ไหนเขาว่าถ่ายรูปแล้วเลิศแล้วเกิดคือต้องไปให้หมด!");
                                tripEntity8.setUrl("https://www.wongnai.com/trips/one-day-trip-kanchanaburi");

                                TripEntity tripEntity9 = new TripEntity();
                                tripEntity9.setTitle(
                                                "ลุยเขาใหญ่แบบ Unexpected! เที่ยวเต็มสูบด้วย น้ำมัน 1 ถัง");
                                tripEntity9.setDescription(
                                                "เที่ยวเขาใหญ่ให้หายคิดถึงกับ แวน เฮ้วซิ่ง แบบ Unexpected ด้วยน้ำมันรถแค่ 1 ถัง ลุยสนุก เที่ยวเต็มสูบ 2 วัน 1 คืน ฤดูไหนก็เที่ยวได้!");
                                tripEntity9.setUrl("https://www.wongnai.com/trips/khaoyai-unexpected");

                                TripEntity tripEntity10 = new TripEntity();
                                tripEntity10.setTitle("เที่ยวเบตง 2 วัน 1 คืน สัมผัสดินแดนใต้สุดแดนสยาม");
                                tripEntity10.setDescription(
                                                "เที่ยวยะลา 2 วัน 1 คืน สัมผัสที่เที่ยวเบตง เมืองเล็ก ๆ ที่อยู่ใต้สุดแดนสยาม เต็มไปด้วยเสน่ห์ของธรรมชาติ ผู้คน และอาหารการกิน ฟินขนาดไหน ไปสัมผัสพร้อม ๆ กัน");
                                tripEntity10.setUrl("https://www.wongnai.com/trips/2-days-betong-yala");

                                tripEntity1 = tripRepository.save(tripEntity1);
                                tripEntity2 = tripRepository.save(tripEntity2);
                                tripEntity3 = tripRepository.save(tripEntity3);
                                tripEntity4 = tripRepository.save(tripEntity4);
                                tripEntity5 = tripRepository.save(tripEntity5);
                                tripEntity6 = tripRepository.save(tripEntity6);
                                tripEntity7 = tripRepository.save(tripEntity7);
                                tripEntity8 = tripRepository.save(tripEntity8);
                                tripEntity9 = tripRepository.save(tripEntity9);
                                tripEntity10 = tripRepository.save(tripEntity10);

                                String[] photoArray1 = {
                                                "https://img.wongnai.com/p/1600x0/2019/07/09/fba496abdb4543f59c710a808dec8e27.jpg",
                                                "https://img.wongnai.com/p/1600x0/2019/12/25/54961e4326954765a80cd20e2044083d.jpg",
                                                "https://img.wongnai.com/p/1600x0/2019/12/25/9bbcb032afc145d19e485defcf2067c1.jpg",
                                                "https://img.wongnai.com/p/1600x0/2019/12/25/2974828fdb16492da0e8f35f627ade7a.jpg"
                                };

                                String[] photoArray2 = {
                                                "https://img.wongnai.com/p/1600x0/2019/06/04/57875ecebd6b4bc3b937b9c4dfee4396.jpg",
                                                "https://img.wongnai.com/p/1600x0/2019/06/04/93b7b555b624490680ebe7b0a16b0519.jpg",
                                                "https://img.wongnai.com/p/1600x0/2019/06/04/bf2c001a72314452a261bff3f039ccdc.jpg",
                                                "https://img.wongnai.com/p/1600x0/2019/06/04/37b377e43f344da794cb3353aeca3fcf.jpg"
                                };

                                String[] photoArray3 = {
                                                "https://img.wongnai.com/p/1600x0/2019/05/21/cd54e9c640694a95b7e0103b0ead5408.jpg",
                                                "https://img.wongnai.com/p/1600x0/2019/05/21/cf792ff02ab0491b9f30d67d33634f78.jpg",
                                                "https://img.wongnai.com/p/1600x0/2019/05/21/e87ce6e73c634532afd50dd02517fee9.jpg",
                                                "https://img.wongnai.com/p/1600x0/2019/05/21/ea0f93584b3c4f3ba0680fcc11bc3a13.jpg"
                                };

                                String[] photoArray4 = {
                                                "https://img.wongnai.com/p/800x0/2024/09/19/6bf401c3464a4d13b2718e40aad69b4c.jpg",
                                                "https://img.wongnai.com/p/800x0/2024/09/19/03f19c9a74824d61a906ed15dd7a5c1f.jpg",
                                                "https://img.wongnai.com/p/800x0/2024/09/19/75ac8c369203468ca63e009f2b274046.jpg",
                                                "https://img.wongnai.com/p/800x0/2024/09/19/a6fcde4105284c31ae2907a3cce8860a.jpg"
                                };

                                String[] photoArray5 = {
                                                "https://img.wongnai.com/p/800x0/2024/09/13/b0633b763c064902a13035499e427fb6.jpg",
                                                "https://img.wongnai.com/p/800x0/2024/09/13/77f477fc6d214d5f9a78816118372d1d.jpg",
                                                "https://img.wongnai.com/p/800x0/2024/09/13/1fd56a7c921849579cef2e42e6cbf698.jpg",
                                                "https://img.wongnai.com/p/800x0/2024/09/13/3f362c5dc8e64fdda97019d7411d5c9f.jpg"
                                };

                                String[] photoArray6 = {
                                                "https://img.wongnai.com/p/800x0/2024/08/29/66cc1ab934fa4bc3b8b00f6f6c8a402d.jpg",
                                                "https://img.wongnai.com/p/800x0/2024/08/29/d1a86759f086466dad6bc767a6664522.jpg",
                                                "https://img.wongnai.com/p/800x0/2024/08/29/e66eadbf179a489081b79af88e67736f.jpg",
                                                "https://img.wongnai.com/p/800x0/2024/08/29/aea9d9f4fda348ce8d5d36bddd85ad31.jpg"
                                };

                                String[] photoArray7 = {
                                                "https://img.wongnai.com/p/400x0/2024/03/15/86c1c8f272dc44338d80b69c5610e950.jpg",
                                                "https://img.wongnai.com/p/400x0/2024/03/15/4d4ce844050241acae555f51aa400ceb.jpg",
                                                "https://img.wongnai.com/p/400x0/2024/03/15/780dc42f188a4002a51d4f7ab08c4a15.jpg",
                                                "https://img.wongnai.com/p/400x0/2024/03/15/d173263373494434bdc8e886af6df15b.jpg"
                                };

                                String[] photoArray8 = {
                                                "https://img.wongnai.com/p/800x0/2023/11/07/6c2016d1a1d44615a052061f4ed4dc3d.jpg",
                                                "https://img.wongnai.com/p/800x0/2023/11/06/e73d07bf1b2e4accb43a8674cbd16afa.jpg",
                                                "https://img.wongnai.com/p/800x0/2023/11/06/a727f275d6c443419bd5871d82610afa.jpg",
                                                "https://img.wongnai.com/p/800x0/2023/11/06/2258fe3d3d914e46abee5d5c3101638a.jpg"
                                };

                                String[] photoArray9 = {
                                                "https://img.wongnai.com/p/800x0/2021/03/01/a264535bf01f49acaa330fe207382a21.jpg",
                                                "https://img.wongnai.com/p/800x0/2021/02/20/3e5c8ca2582e40dd89a815c97ab7682b.jpg",
                                                "https://img.wongnai.com/p/800x0/2021/02/20/6e11a8e29da4420ca4c908304a70aeb5.jpg",
                                                "https://img.wongnai.com/p/800x0/2021/02/20/69fee6b8a7394c009486b288e8a8b9fa.jpg"
                                };

                                String[] photoArray10 = {
                                                "https://img.wongnai.com/p/1920x0/2019/01/20/32d324b0a1c04a8f834d6072a0dcab75.jpg",
                                                "https://img.wongnai.com/p/800x0/2019/01/20/10e622d2a3b348ca83f9b38377ae5c60.jpg",
                                                "https://img.wongnai.com/p/800x0/2019/01/20/bb21293096a44850b5c5e018eef82695.jpg",
                                                "https://img.wongnai.com/p/800x0/2019/01/20/b0a2a91e53a844569481e0a256733c8f.jpg"
                                };

                                for (int i = 0; i < photoArray1.length; i++) {
                                        PhotoEntity photoEntity = new PhotoEntity();
                                        photoEntity.setTripId(tripEntity1);
                                        photoEntity.setPriority(i);
                                        photoEntity.setUrl(photoArray1[i]);
                                        photoRepository.save(photoEntity);
                                }

                                for (int i = 0; i < photoArray2.length; i++) {
                                        PhotoEntity photoEntity = new PhotoEntity();
                                        photoEntity.setTripId(tripEntity2);
                                        photoEntity.setPriority(i);
                                        photoEntity.setUrl(photoArray2[i]);
                                        photoRepository.save(photoEntity);
                                }

                                for (int i = 0; i < photoArray3.length; i++) {
                                        PhotoEntity photoEntity = new PhotoEntity();
                                        photoEntity.setTripId(tripEntity3);
                                        photoEntity.setPriority(i);
                                        photoEntity.setUrl(photoArray3[i]);
                                        photoRepository.save(photoEntity);
                                }

                                for (int i = 0; i < photoArray4.length; i++) {
                                        PhotoEntity photoEntity = new PhotoEntity();
                                        photoEntity.setTripId(tripEntity4);
                                        photoEntity.setPriority(i);
                                        photoEntity.setUrl(photoArray4[i]);
                                        photoRepository.save(photoEntity);
                                }

                                for (int i = 0; i < photoArray5.length; i++) {
                                        PhotoEntity photoEntity = new PhotoEntity();
                                        photoEntity.setTripId(tripEntity5);
                                        photoEntity.setPriority(i);
                                        photoEntity.setUrl(photoArray5[i]);
                                        photoRepository.save(photoEntity);
                                }

                                for (int i = 0; i < photoArray6.length; i++) {
                                        PhotoEntity photoEntity = new PhotoEntity();
                                        photoEntity.setTripId(tripEntity6);
                                        photoEntity.setPriority(i);
                                        photoEntity.setUrl(photoArray6[i]);
                                        photoRepository.save(photoEntity);
                                }

                                for (int i = 0; i < photoArray7.length; i++) {
                                        PhotoEntity photoEntity = new PhotoEntity();
                                        photoEntity.setTripId(tripEntity7);
                                        photoEntity.setPriority(i);
                                        photoEntity.setUrl(photoArray7[i]);
                                        photoRepository.save(photoEntity);
                                }

                                for (int i = 0; i < photoArray8.length; i++) {
                                        PhotoEntity photoEntity = new PhotoEntity();
                                        photoEntity.setTripId(tripEntity8);
                                        photoEntity.setPriority(i);
                                        photoEntity.setUrl(photoArray8[i]);
                                        photoRepository.save(photoEntity);
                                }

                                for (int i = 0; i < photoArray9.length; i++) {
                                        PhotoEntity photoEntity = new PhotoEntity();
                                        photoEntity.setTripId(tripEntity9);
                                        photoEntity.setPriority(i);
                                        photoEntity.setUrl(photoArray9[i]);
                                        photoRepository.save(photoEntity);
                                }

                                for (int i = 0; i < photoArray10.length; i++) {
                                        PhotoEntity photoEntity = new PhotoEntity();
                                        photoEntity.setTripId(tripEntity10);
                                        photoEntity.setPriority(i);
                                        photoEntity.setUrl(photoArray10[i]);
                                        photoRepository.save(photoEntity);
                                }

                                String[] tagArray = {
                                                "จุดถ่ายรูป",
                                                "หมู่บ้าน",
                                                "ภูเขา",
                                                "ธรรมชาติ",
                                                "ถ่ายรูปสวย",
                                                "บ้านอีต่องเหมืองปิล็อก",
                                                "กาญจนบุรี",
                                                "ต่างประเทศ",
                                                "ญี่ปุ่น",
                                                "ฟินแลนด์",
                                                "หิมะ",
                                                "ที่เที่ยวหน้าหนาว",
                                                "เที่ยวไหนดี",
                                                "ทะเล",
                                                "ตราด",
                                                "ที่เที่ยว",
                                                "วังหลวง",
                                                "อาหารญี่ปุ่น",
                                                "กินใกล้กรุง",
                                                "คาเฟ่",
                                                "เที่ยวได้ทั้งปี",
                                                "บรรยากาศดี",
                                };

                                TagEntity tagEntity1 = new TagEntity();
                                tagEntity1.setName("จุดถ่ายรูป");
                                TagEntity tagEntity2 = new TagEntity();
                                tagEntity2.setName("หมู่บ้าน");
                                TagEntity tagEntity3 = new TagEntity();
                                tagEntity3.setName("ภูเขา");
                                TagEntity tagEntity4 = new TagEntity();
                                tagEntity4.setName("ธรรมชาติ");
                                TagEntity tagEntity5 = new TagEntity();
                                tagEntity5.setName("ถ่ายรูปสวย");
                                TagEntity tagEntity6 = new TagEntity();
                                tagEntity6.setName("บ้านอีต่องเหมืองปิล็อก");
                                TagEntity tagEntity7 = new TagEntity();
                                tagEntity7.setName("กาญจนบุรี");
                                TagEntity tagEntity8 = new TagEntity();
                                tagEntity8.setName("ต่างประเทศ");
                                TagEntity tagEntity9 = new TagEntity();
                                tagEntity9.setName("ญี่ปุ่น");
                                TagEntity tagEntity10 = new TagEntity();
                                tagEntity10.setName("ฟินแลนด์");
                                TagEntity tagEntity11 = new TagEntity();
                                tagEntity11.setName("หิมะ");
                                TagEntity tagEntity12 = new TagEntity();
                                tagEntity12.setName("ที่เที่ยวหน้าหนาว");
                                TagEntity tagEntity13 = new TagEntity();
                                tagEntity13.setName("เที่ยวไหนดี");
                                TagEntity tagEntity14 = new TagEntity();
                                tagEntity14.setName("ทะเล");
                                TagEntity tagEntity15 = new TagEntity();
                                tagEntity15.setName("ตราด");
                                TagEntity tagEntity16 = new TagEntity();
                                tagEntity16.setName("ที่เที่ยว");
                                TagEntity tagEntity17 = new TagEntity();
                                tagEntity17.setName("วังหลวง");
                                TagEntity tagEntity18 = new TagEntity();
                                tagEntity18.setName("อาหารญี่ปุ่น");
                                TagEntity tagEntity19 = new TagEntity();
                                tagEntity19.setName("กินใกล้กรุง");
                                TagEntity tagEntity20 = new TagEntity();
                                tagEntity20.setName("คาเฟ่");
                                TagEntity tagEntity21 = new TagEntity();
                                tagEntity21.setName("เที่ยวได้ทั้งปี");
                                TagEntity tagEntity22 = new TagEntity();
                                tagEntity22.setName("บรรยากาศดี");

                                tagEntity1 = tagRepository.save(tagEntity1);
                                tagEntity2 = tagRepository.save(tagEntity2);
                                tagEntity3 = tagRepository.save(tagEntity3);
                                tagEntity4 = tagRepository.save(tagEntity4);
                                tagEntity5 = tagRepository.save(tagEntity5);
                                tagEntity6 = tagRepository.save(tagEntity6);
                                tagEntity7 = tagRepository.save(tagEntity7);
                                tagEntity8 = tagRepository.save(tagEntity8);
                                tagEntity9 = tagRepository.save(tagEntity9);
                                tagEntity10 = tagRepository.save(tagEntity10);
                                tagEntity11 = tagRepository.save(tagEntity11);
                                tagEntity12 = tagRepository.save(tagEntity12);
                                tagEntity13 = tagRepository.save(tagEntity13);
                                tagEntity14 = tagRepository.save(tagEntity14);
                                tagEntity15 = tagRepository.save(tagEntity15);
                                tagEntity16 = tagRepository.save(tagEntity16);
                                tagEntity17 = tagRepository.save(tagEntity17);
                                tagEntity18 = tagRepository.save(tagEntity18);
                                tagEntity19 = tagRepository.save(tagEntity19);
                                tagEntity20 = tagRepository.save(tagEntity20);
                                tagEntity21 = tagRepository.save(tagEntity21);
                                tagEntity22 = tagRepository.save(tagEntity22);

                                // tripEntity1
                                TripTagEntity tripTagEntity1 = new TripTagEntity();
                                tripTagEntity1.setTripId(tripEntity1);
                                tripTagEntity1.setTagId(tagEntity14);
                                TripTagEntity tripTagEntity2 = new TripTagEntity();
                                tripTagEntity2.setTripId(tripEntity1);
                                tripTagEntity2.setTagId(tagEntity15);
                                TripTagEntity tripTagEntity3 = new TripTagEntity();
                                tripTagEntity3.setTripId(tripEntity1);
                                tripTagEntity3.setTagId(tagEntity4);
                                tripTagRepository.save(tripTagEntity1);
                                tripTagRepository.save(tripTagEntity2);
                                tripTagRepository.save(tripTagEntity3);

                                // tripEntity2
                                TripTagEntity tripTagEntity4 = new TripTagEntity();
                                tripTagEntity4.setTripId(tripEntity2);
                                tripTagEntity4.setTagId(tagEntity9);
                                TripTagEntity tripTagEntity5 = new TripTagEntity();
                                tripTagEntity5.setTripId(tripEntity2);
                                tripTagEntity5.setTagId(tagEntity4);
                                tripTagRepository.save(tripTagEntity4);
                                tripTagRepository.save(tripTagEntity5);
                                tripTagEntity5 = new TripTagEntity();
                                tripTagEntity5.setTripId(tripEntity2);
                                tripTagEntity5.setTagId(tagEntity3);
                                tripTagRepository.save(tripTagEntity5);

                                // tripEntity3
                                TripTagEntity tripTagEntity6 = new TripTagEntity();
                                tripTagEntity6.setTripId(tripEntity3);
                                tripTagEntity6.setTagId(tagEntity16);
                                tripTagRepository.save(tripTagEntity6);
                                tripTagEntity6 = new TripTagEntity();
                                tripTagEntity6.setTripId(tripEntity3);
                                tripTagEntity6.setTagId(tagEntity3);
                                tripTagRepository.save(tripTagEntity6);

                                // tripEntity4
                                TripTagEntity tripTagEntity7 = new TripTagEntity();
                                tripTagEntity7.setTripId(tripEntity4);
                                tripTagEntity7.setTagId(tagEntity17);
                                TripTagEntity tripTagEntity8 = new TripTagEntity();
                                tripTagEntity8.setTripId(tripEntity4);
                                tripTagEntity8.setTagId(tagEntity18);
                                tripTagRepository.save(tripTagEntity7);
                                tripTagRepository.save(tripTagEntity8);

                                // tripEntity5
                                TripTagEntity tripTagEntity9 = new TripTagEntity();
                                tripTagEntity9.setTripId(tripEntity5);
                                tripTagEntity9.setTagId(tagEntity19);
                                TripTagEntity tripTagEntity10 = new TripTagEntity();
                                tripTagEntity10.setTripId(tripEntity5);
                                tripTagEntity10.setTagId(tagEntity20);
                                tripTagRepository.save(tripTagEntity9);
                                tripTagRepository.save(tripTagEntity10);

                                // tripEntity6
                                TripTagEntity tripTagEntity11 = new TripTagEntity();
                                tripTagEntity11.setTripId(tripEntity6);
                                tripTagEntity11.setTagId(tagEntity19);
                                TripTagEntity tripTagEntity12 = new TripTagEntity();
                                tripTagEntity12.setTripId(tripEntity6);
                                tripTagEntity12.setTagId(tagEntity18);
                                tripTagRepository.save(tripTagEntity11);
                                tripTagRepository.save(tripTagEntity12);

                                // tripEntity7
                                TripTagEntity tripTagEntity13 = new TripTagEntity();
                                tripTagEntity13.setTripId(tripEntity7);
                                tripTagEntity13.setTagId(tagEntity7);
                                tripTagRepository.save(tripTagEntity13);
                                tripTagEntity13 = new TripTagEntity();
                                tripTagEntity13.setTripId(tripEntity7);
                                tripTagEntity13.setTagId(tagEntity16);
                                tripTagRepository.save(tripTagEntity13);
                                tripTagEntity13 = new TripTagEntity();
                                tripTagEntity13.setTripId(tripEntity7);
                                tripTagEntity13.setTagId(tagEntity4);
                                tripTagRepository.save(tripTagEntity13);

                                // tripEntity8
                                TripTagEntity tripTagEntity14 = new TripTagEntity();
                                tripTagEntity14.setTripId(tripEntity8);
                                tripTagEntity14.setTagId(tagEntity7);
                                TripTagEntity tripTagEntity15 = new TripTagEntity();
                                tripTagEntity15.setTripId(tripEntity8);
                                tripTagEntity15.setTagId(tagEntity16);
                                tripTagRepository.save(tripTagEntity14);
                                tripTagRepository.save(tripTagEntity15);

                                // tripEntity9
                                TripTagEntity tripTagEntity16 = new TripTagEntity();
                                tripTagEntity16.setTripId(tripEntity9);
                                tripTagEntity16.setTagId(tagEntity16);
                                TripTagEntity tripTagEntity17 = new TripTagEntity();
                                tripTagEntity17.setTripId(tripEntity9);
                                tripTagEntity17.setTagId(tagEntity20);
                                TripTagEntity tripTagEntity18 = new TripTagEntity();
                                tripTagEntity18.setTripId(tripEntity9);
                                tripTagEntity18.setTagId(tagEntity21);
                                tripTagRepository.save(tripTagEntity16);
                                tripTagRepository.save(tripTagEntity17);
                                tripTagRepository.save(tripTagEntity18);

                                // tripEntity10
                                TripTagEntity tripTagEntity19 = new TripTagEntity();
                                tripTagEntity19.setTripId(tripEntity10);
                                tripTagEntity19.setTagId(tagEntity1);
                                TripTagEntity tripTagEntity20 = new TripTagEntity();
                                tripTagEntity20.setTripId(tripEntity10);
                                tripTagEntity20.setTagId(tagEntity16);
                                TripTagEntity tripTagEntity21 = new TripTagEntity();
                                tripTagEntity21.setTripId(tripEntity10);
                                tripTagEntity21.setTagId(tagEntity22);
                                tripTagRepository.save(tripTagEntity19);
                                tripTagRepository.save(tripTagEntity20);
                                tripTagRepository.save(tripTagEntity21);
                        }
                } catch (Exception e) {
                }
        }

        private boolean isDatabaseConnected() {
                try {
                        jdbcTemplate.queryForObject("SELECT 1", Integer.class);
                        return true;
                } catch (Exception e) {
                        logger.error("Database connection failed " + e.getMessage());
                        return false;
                }
        }

}
